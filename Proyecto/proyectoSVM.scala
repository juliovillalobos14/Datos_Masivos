//Load libraries
import org.apache.spark.mllib.classification.{SVMModel, SVMWithSGD}
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.DateType
import org.apache.spark.sql.{SparkSession, SQLContext}
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.Transformer
import org.apache.spark.ml.classification.LinearSVC

//Load data and we start Sparksession
val spark = SparkSession.builder().getOrCreate()
val data = spark.read.option("header","true").option("inferSchema","true").option("delimiter",";").format("csv").load("bank-full.csv")
//see the main features of the dataframe
data.printSchema()
data.show(2)
//We chance de column "y" for a column with data binary
val change1 = data.withColumn("y",when(col("y").equalTo("yes"),1).otherwise(col("y")))
val change2 = change1.withColumn("y",when(col("y").equalTo("no"),2).otherwise(col("y")))
val newcolumn = change2.withColumn("y",'y.cast("Int"))
//See the new column
newcolumn.show(1)

//We create a new column with the features of the someones columns
val assembler = new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features")
val fea = assembler.transform(newcolumn)
//See the column with features
fea.show(1)
//We change the name of the column "y" to "label" so that it is the class column
val cambio = fea.withColumnRenamed("y", "label")
val feat = cambio.select("label","features")
//The new dataframe only have 2 columns for use SVM
feat.show(2)

//SVM
val c1 = feat.withColumn("label",when(col("label").equalTo("1"),0).otherwise(col("label")))
val c2 = c1.withColumn("label",when(col("label").equalTo("2"),1).otherwise(col("label")))
val c3 = c2.withColumn("label",'label.cast("Int"))
val linsvc = new LinearSVC().setMaxIter(10).setRegParam(0.1)
// Fit the model
val linsvcModel = linsvc.fit(c3)
// Print the coefficients and intercept for linear svc
println(s"Coefficients: ${linsvcModel.coefficients} Intercept: ${linsvcModel.intercept}")