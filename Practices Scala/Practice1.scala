import org.apache.spark.sql.SparkSession
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
//package es.us.cluster
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.sql.{SparkSession, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}
val spark = SparkSession.builder().getOrCreate()
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.classification.MultilayerPerceptronClassificationModel
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.IndexToString
import org.apache.spark.ml.Pipeline


//val data = spark.read.csv("Wholesale customers data.csv", header=True, inferSchema=True)

val df = spark.read.option("header", "true").option("inferSchema","true")csv("Wholesale customers data.csv")
//val dataset = spark.read.format("libsvm").load("sample_kmeans_data.txt")
val data = df.select($"Region",$"Fresh",$"Milk",$"Grocery",$"Frozen",$"Detergents_Paper",$"Delicassen")
val assembler = new VectorAssembler()
.setInputCols(Array("Region", "Fresh", "Milk", "Grocery","Frozen","Detergents_Paper","Delicassen"))
.setOutputCol("features")

val features = assembler.transform(data)
val ul = features.select("features")




//Preparing to data
//assembler = VectorAssembler(inputCols=cols, outputCol='features')

//Empezando el análisis observamos el esquema del dataframe
//df.printSchema()
//Hay que ver las primeras columnas, para saber como esta
//Construido el dataframe
//df.show(5)
//Hay que ver que en ninguna columna existan datos nulos o vacíos
//df.filter("Region is null").count
//df.filter("Fresh is null").count
//df.filter("Milk is null").count
//df.filter("Grocery is null").count
//df.filter("Frozen is null").count
//df.filter("Detergents_Paper is null").count
//df.filter("Delicassen is null").count

//trains the k-means model
//val pipeline = new Pipeline()
//.setStages(Array(labelIndexer, featureIndexer, trainer, labelConverter))

val kmeans = new KMeans().setK(2).setSeed(1L)
val model = kmeans.fit(df)

// Evaluate clustering by calculate Within Set Sum of Squared Errors.
//val WSSE = model.computeCost(df)
//println(s"Within set sum of Squared Errors = $WSSE")

// Show results
//println("Cluster Centers: ")
//model.clusterCenters.foreach(println)
