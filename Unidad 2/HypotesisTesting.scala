// Importamos para el uso de vectores
import org.apache.spark.ml.linalg.{Vector, Vectors}
// Importamos para aplicar chicuadrada
import org.apache.spark.ml.stat.ChiSquareTest

// Set de datos a utilizar
val data = Seq(
  (0.0, Vectors.dense(0.5, 10.0)),
  (0.0, Vectors.dense(1.5, 20.0)),
  (1.0, Vectors.dense(1.5, 30.0)),
  (0.0, Vectors.dense(3.5, 30.0)),
  (0.0, Vectors.dense(3.5, 40.0)),
  (1.0, Vectors.dense(3.5, 40.0))
)

//Aplicación de test de chicuadrada
//La variabel df se convierte en un dataset con dos columnas, que son label y features
val df = data.toDF("label", "features")
//La variable chi toma la información del dataset para después aplicar el test de chi cuadrada 
//y encontrar si los valores que se encuentran en la columna "features" influyen en la clasificación
//de la columna "label"
val chi = ChiSquareTest.test(df, "features", "label").head
//Existe un margen de error de 0,05
//Como hipótesis nula tenemos: "features" no influyen en label
//Como hipótesis alternativa tenemos: "features" si influyen en label
// pValues es la probabilidad de encontrar un valor mayor o igual al chi_cuadrado de acuerdo al nivel de significancia
println(s"pValues = ${chi.getAs[Vector](0)}")
// degreesOfFreedom = (Numero_Filas - 1) (Numero_Columnas - 1) 
println(s"degreesOfFreedom ${chi.getSeq[Int](1).mkString("[", ",", "]")}")
// Por condición si chi_cuadrado > valor_tabla = Se rechaza la hipotesis nula
// Por condición si chi_cuadrado < valor_tabla = Se rechaza la hipotesis alternativa
println(s"statistics ${chi.getAs[Vector](2)}")
