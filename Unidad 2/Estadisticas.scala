//Construcción de un DataFrame

val df = Seq(
    ("Paco", "Garcia",24, 24000),
    ("Juan", "Garcia", 26, 27000),
    ("Lola", "Martin", 29, 31000),
    ("Sara", "Martin", 32, 32000),
    ("Sara", "Garcia", 35, 34000)
).toDF("nombre", "apellido", "edad", "salario")

//Mostramos el promedio de edad del DF
df.select(avg("edad")).show()


//Mostramos la suma de todas las edades de la columna edad
df.select(sum("edad")).show()

//Mostramos la mínima edad que se encuentra en la columna edad
df.select(min("edad")).show()

//Mostramos la máxima edad que se encuentra en la columna edad
df.select(max("edad")).show()

//Apartir de un subconjunto de datos agrupados calculamos la media
// y el valor máximo.
df.groupBy(df.col("apellido")).agg(avg("edad"), max("salario")).show()

//Calculamos la correlación de Pearson entre la columna edad y salario
df.stat.corr("edad", "salario")

//Calculamos la covarianza entre la columna edad y salario
df.stat.cov("edad", "salario")
