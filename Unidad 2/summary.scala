//Importamos las librerías
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.Summarizer

//DataSet
val data = Seq(
  (Vectors.dense(2.0, 3.0, 5.0), 1.0),
  (Vectors.dense(4.0, 6.0, 7.0), 2.0)
)
//Conversion de la estructura de datos a un DataSet
val df = data.toDF("features", "weight")

//Se calcula la mediana y la varianza
val (meanVal, varianceVal) = df.select(metrics("mean", "variance")
  .summary($"features", $"weight").as("summary"))
  .select("summary.mean", "summary.variance")
  .as[(Vector, Vector)].first()
//Se imprime la mediana y la varianza del DataSet
println(s"with weight: mean = ${meanVal}, variance = ${varianceVal}")

//Se calcula la mediana y la varianza
val (meanVal2, varianceVal2) = df.select(mean($"features"), variance($"features"))
  .as[(Vector, Vector)].first()
//Se imprime la mediana y la varianza del DataSet
println(s"without weight: mean = ${meanVal2}, sum = ${varianceVal2}")