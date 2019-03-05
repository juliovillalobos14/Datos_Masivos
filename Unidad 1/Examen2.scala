// 1. Comienza una simple sesión en Spark
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

//2. Cargue el archivo Netflix Stock CSV, haga que spark infiera los tipos de datos
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

//3. Cuáles son los nombres de las columnas?
df.printSchema()

// 4.Cómo es el esquema?
df.printSchema()

// 5. Imprimir las primeras 5 columnas
df.show(5)

//6. Usar describe para aprender más sobre el Dataframe
val descri = df.describe()
descri.show()

// 7. Crear nuevo Dataframe con una columna nueva llama "HV Ratio" que es la relación entre el precio de la columna
// "Hight" frente a la columna "Volume" de acciones negociadas por día
val df2 = df.withColumn("HV Ratio", df("High")+df("Low"))
df2.show()

//8. Qué día tuvo el pico más alto de la columna en la columna "Hight"?
df.orderBy($"High".desc).show()

// 9. Cuál es el significado de la columna cerrar "Close"
//Es el resultado de la relación que existe entre la columna "High" y "Low", es el cierre

// 10.Cuál es le máximo y minímo de la columna Volume
df.select(min("Volume")).show()
df.select(max("Volume")).show()

// 11. Con sintaxis Scala/Spark $ contestar lo siguiente
    //a. Cuántos días fue la columna "Close" ingferior a $600
    val df4 = df.filter($"Close" < 600)
    df4.count() 

    //b. Que porcentaje del tiempo fue la columna "Hight" mayor a $500 
    val df5 = df.filter($"Close" > 500)
    df5.count()

    //c. Cuál es la correlación de Pearson entre columna "Hight" y la columna "Volumen"?
    df.select(corr("High", "Volume")).show()

    //d. Cuál es el máximo de la columna "High" por año?
    val df6 = df.withColumn("Year", year(df("Date")))
    val df6max = df6.groupBy("Year").max()
    df6max.select($"Year", $"max(High)").show() 

    //e. Cuál es promedio de la columna "Close" para cada mes del calendario? 
    val df7 = df.withColumn("Month", month(df("Date")))
    val df7mean = df7.groupBy("Month").mean()
    df7mean.select($"Month", $"avg(Close)").show()    
