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

// 2da Función
//Vemos el número de valores distintos que existen en la columna
df.select(approx_count_distinct("Close")).show()

//3ra Función
//Vemos una lista de los objetos que están duplicados
df.select(collect_list("Close")).show()

//4ta Función
//Vemos la correlaciónd de Pearson en la columna
df.select(corr("Close", "Volume")).show()

//5ta función
//Cuenta la cantidad de elementos que hay en la columna
df.select(count("Close")).show()

//6ta Función
//Vemos la cantidad de elementos distintos que hay en la columna
df.select(countDistinct("Close")).show()

//7ma Función
//Regresa el skewness dea la columna
df.select(skewness("Close")).show()

//8va Función
//Suma de los valores distintos que hay en el columna
df.select(sumDistinct("Close")).show()

//9na Función
//Remueve los valores duplicados de la columna
df.select(array_distinct("Close")).show()

//10ma Función
//Regresa null si la columna contiene null, true si contiene valores y false si contiene ambos
df.select(array_contains("Close",null)).show()

//11va Función
//Regresa el primero de la del grupo o columna
df.select(first("Close")).show()

//12va Función
//Agrupamos los datos
df.select(grouping("Close")).show()

//13va Funcióm
//Devuelve el valor de kurtosis de la columna o array
df.select(kurtosis("Close")).show()

//14va Función
//Vemos el último valor de la columna
df.select(last("Close")).show()

//15va Función
//Desviación estándar
df.select(stddev("Close")).show()

//16va Función
// Desviación estándar pop
df.select(stddev_pop("Close")).show()

//17 Función
//Desviación estándar sam
df.select(stddev("Close")).show()

//18 Función
// varianza pop
df.select(var_pop("Close")).show()

//19 Función
//Varianza sam
df.select(var_samp("Close")).show()

//20 Función
//Variance
df.select(variance("Close")).show()