//Importamos la librería de spark sql, para poder
// hacer consultas de tipo sql a demás de las de spark
import org.apache.spark.sql.SparkSession

//Declaramos una variable que contendrá la sesión de spark
val spark = SparkSession.builder().getOrCreate()

//Creamos otra variable que contendrá el dataframe que usaremos
val df = spark.read.option("header", "true").option("inferSchema", "true")csv("CitiGroup2006_2008")

//Vemos el esquema del dataframe
df.printSchema()

// 1ra función
//Promedio de una columna
df.select(avg("Close")).show()