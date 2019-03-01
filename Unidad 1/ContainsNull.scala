//Iniciamos la Sesión  de SparkSql
import org.apache.spark.sql.SparkSession
//Agregamos a una variable la sesión de SparkSql
val spar = SparkSession.builder().getOrCreate()
//La variable df contiene el datasets con el que trabajaremos, el cual se encuentra en la misma ubicación 
//del archivo
val df = spark.read.option("header", "true").option("inferSchema","true")csv("ContainsNull.csv")
//Vemos el esquema del dataset modificado
//df.printSchema()
//Vemos el datasets, ya que es pequeño no hay problema en ver los datos
df.show()
val dd = df.Sales
array_distinct(df.Sales).show()

//Eliminamos aquellos datos que aparecen como nullos
//df.na.drop().show()
//Al ser doblemente negado, no sufre cambios el dataset
//df.na.drop(2).show()
//Rellenamos aquellos campos vaciós con el dato de 100, cabe mencionar que scala solo modificará 
//los datos que son nulos y que son de tipo Int
//df.na.fill(100).show()
//Rellenará con "Missin Name" los campos en donde sea un dato null y de tipo string, mismo tipo
//con el que se rellenará
//df.na.fill("Missing Name").show()
//En la columna "Name" rellenará con "New Name" aquellos campos que sean null
//Se menciona como Array ya que una columna es un Array
//df.na.fill("New name", Array("Name")).show() 
//En la columna "Sales" rellenaremos los datos null con el número 200, ya que es una columna de tipo Int (Array)
//df.na.fill(200, Array("Sales")).show() 
//Con está función vemos datos de estadística básica
//df.describe().show()
//df.na.fill(400.5, Array("Sales")).show()
//df.na.fill("Missing name", Array("Name")).show()

//val df2 =df.na.fill(400.5, Array("Sales"))
//df2.na.fill("Missing name", Array("Name")).show()
// result = df2.na.fill("Missing name", Array("Name")).show()

//Práctica
//Hacer 3 columnas, dos strings y 1 numerica
// Edad, Date, City