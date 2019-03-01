//Importamos la librería de spark sql, para poder
// hacer consultas de tipo sql a demás de las de spark
import org.apache.spark.sql.SparkSession

//Declaramos una variable que contendrá la sesión de spark
val spark = SparkSession.builder().getOrCreate()

//Creamos otra variable que contendrá el dataframe que usaremos
val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008")

df.printSchema()

df.head(2)

df.select(month(df("Date"))).show()

df.select(year(df("Date"))).show()

val df2 = df.withColumn("Year", year(df("Date")))

val dfavgs = df2.groupBy("Year").mean()

dfavgs.select($"Year", $"avg(Close)").show()

val dfmins = df2.groupBy("Year").min()

dfmins.select($"Year", $"min(Close)").show()

//Práctica, aplicar 15 funciones de DateTime

//1ra función
//Regresa el current de la columna de Date que se selecciona
df.select(current_date()).show()

//2da función
//El último día de la columna de tipos Dates
df.select(last_day(df("Date"))).show()

//3ra función
//Agregar una nuev fecha a la columna Date
df.select(date_add(df("Date", 1))

//4ta función
//Agregar mes a un tipo de dato Date
df.select(add_months("Date", 2))

//5ta función
//Ver el timempo del current de Date
df.select(current_timestamp()).show()

//6ta función
//Convertir o ver el tipo de dato de la fecha
df.select(date_format("Date", )).show()

//7ma función
//Diferencia de las fechas de acuerdo a las fechas dadas
df.select(datediff("Date", "Date")).show()

//8va función
//Ver día de un mes de acuerdo a columna
df.select(dayofmonth(df("Date"))).show()

//9na función
//día de la semana de acuerdo a la columna
df.select(dayofweek(df("Date"))).show()

//10ma función
//día del año de acuerdo a la columna dada
df.select(dayofyear(df("Date"))).show()