//Importamos las librerías necesarias
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.{VectorAssembler,StringIndexer,VectorIndexer,OneHotEncoder}
import org.apache.spark.ml.linalg.Vectors
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

// Cargamos el dataframe e iniciamos una sesión en SparkSession
val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header","true").option("inferSchema","true").csv("Wholesale customers data.csv")

//Se seleccionan las columnas que se usaran de features para su clasificación y crear clases
val feature_data = df.select($"Fresh", $"Milk", $"Grocery", $"Frozen", $"Detergents_Paper", $"Delicassen")
val assembler = new VectorAssembler().setInputCols(Array("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")).setOutputCol("features")

//Creamos la data de entrenamiento
val traning = assembler.transform(feature_data)
//Entreamos la data para crear el modelo
val kmeans = new KMeans().setK(2).setSeed(1L)
val model = kmeans.fit(traning)

// Errores cuadraticos
val WSSSE = model.computeCost(traning)
println(s"Within Set Sum of Squared Errors = $WSSSE")
//Impresión de los resultados y los centroides
println("Cluster Centers: ")
model.clusterCenters.foreach(println)