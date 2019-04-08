//Importamos librerías
import org.apache.spark.sql.SQLContext
import org.apache.spark.mllib.stat.Statistics

// Generamos un conjunto de datos random los cuales serán un DataFrame
val df = Seq(
    ( 24, 24000),
    ( 26, 27000),
    ( 29, 31000),
    ( 32, 32000),
    ( 35, 34000)
).toDF("x", "y")

df.show(5)

// Seleccionamos columnas y estraemos sus valores
val rddX = df.select($"x").rdd.map(_.getDouble(0))
val rddY = df.select($"y").rdd.map(_.getDouble(0))

val correlation: Double = Statistics.corr(rddX, rddY, "spearman")