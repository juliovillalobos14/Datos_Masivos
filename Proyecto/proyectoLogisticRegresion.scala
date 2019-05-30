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
import org.apache.spark.ml.classification.LogisticRegression

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

//Logistic Regresion

val logistic = new LogisticRegression().setMaxIter(10).setRegParam(0.3).setElasticNetParam(0.8)
// Fit the model
val logisticModel = logistic.fit(feat)
// Print the coefficients and intercept for logistic regression
println(s"Coefficients: ${logisticModel.coefficients} Intercept: ${logisticModel.intercept}")
// We can also use the multinomial family for binary classification
val logisticMult = new LogisticRegression().setMaxIter(10).setRegParam(0.3).setElasticNetParam(0.8).setFamily("multinomial")
val logisticMultModel = logisticMult.fit(feat)
// Print the coefficients and intercepts for logistic regression with multinomial family
println(s"Multinomial coefficients: ${logisticMultModel.coefficientMatrix}")
println(s"Multinomial intercepts: ${logisticMultModel.interceptVector}")