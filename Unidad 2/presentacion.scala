// Librería para el uso de vectores
import org.apache.spark.mllib.linalg.Vectors
// Estadisticas
import org.apache.spark.mllib.stat.{MultivariateStatisticalSummary, Statistics}

//Matriz de datos
val observations = sc.parallelize(
  Seq(
    Vectors.dense(1.0, 10.0, 100.0),
    Vectors.dense(2.0, 20.0, 200.0),
    Vectors.dense(3.0, 30.0, 300.0)
  )
)

// Calcular las estadísticas de resumen.
val summary: MultivariateStatisticalSummary = Statistics.colStats(observations)
println(summary.mean)  // Un vector que contiene el valor medio de cada columna
println(summary.variance)  // Columna de las varianzas
println(summary.numNonzeros)  // Número de ceros en cada columna