//Importamos las líbrerías necesarias para trabajar
//Librería de MultilayerPerceptron para clasificar
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.IndexToString
import org.apache.spark.ml.Pipeline
//Cargamos la data de Iris que será el DataFrame
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Iris.csv")

//Renombramos las columnas
val newnames = Seq("Sepal_Length","Sepal_Width","Petal_Length","Petal_Width","Species")
//Nuevo DataFrames con las cabeceras renombradas
val dfRenamed = df.toDF(newnames: _*)

val data = dfRenamed.select($"Sepal_Length",$"Sepal_Width",$"Petal_Length",$"Petal_Width",$"Species".as("label"))

val assembler = new VectorAssembler()
.setInputCols(Array("Sepal_Length", "Sepal_Width", "Petal_Length", "Petal_Width"))
.setOutputCol("features")

val features = assembler.transform(data)

val splits = features.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)

val layers = Array[Int](3, 2, 3, 2)

val trainer = new MultilayerPerceptronClassifier()
.setLayers(layers)
.setBlockSize(128)
.setSeed(1234L)
.setMaxIter(100)

val model = trainer.fit(train)

val result = model.transform(test)