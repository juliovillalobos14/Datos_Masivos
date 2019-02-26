//Importamos la librería de spark sql, para poder
// hacer consultas de tipo sql a demás de las de spark
import org.apache.spark.sql.SparkSession

//Declaramos una variable que contendrá la sesión de spark
val spark = SparkSession.builder().getOrCreate()

//Creamos otra variable que contendrá el dataframe que usaremos
val df = spark.read.option("header", "true").option("inferSchema", "true")csv("CitiGroup2006_2008")

//Vemos el esquema del dataframe
df.printSchema()

//Hay dos maneras de realizar filtros
// 1. Con Scala
// 2. Con SparkSql

import spark.implicits._

//Devolvemos aquellos en donde "Close" sea mayor a 480 en notación de Scala
df.filter($"Close">480).show()

//Misma consulta que la anterior pero usando la notación en SparkSql
df.filter("Close > 480").show()

//Mostrar aquellos donde "Close" sea menor a 480 y "High" menor a 480
df.filter($"Close" < 480 && $"High" < 480).show()
df.filter("Close < 480 AND High < 480").show()

//Coleccionando los resultados en una variable
val result = df.filter($"Close" < 480 && $"High" < 480).collect()

//Contando los resultados
val result = df.filter($"Close" < 480 && $"High" < 480).count()

//Mostrando un dato que sea de un valor en especifico
df.filter($"High"===484.40).show()
df.filter("High = 484.40").show()

//Mostrando la famosa corelación de pearson
df.select(corr("High", "Low")).show()

//Documentación
////https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$