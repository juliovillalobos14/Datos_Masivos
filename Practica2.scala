

object Practica2 {
  def main(args: Array[String]): Unit = {
    
  // 1. Desarrollar un algoritmo en Scala que calcule el radio de un circulo
  val Lista_Circunferencias = List(15,20,30)
  val pi = 3.14
  
  for(name <- Lista_Circunferencias) {
     
  val radio = name / (2 * pi)
  println("El radio del circulo con circunferencia de " + name + " Es de: " + radio)
  
  }
  
  // 2. Desarrollar un algoritmo que diga si un número es par
  val Lista_Numero = List(2,3,7,10)
  for(name <- Lista_Numero) {
    if(name % 2 == 0) {
      println("El número " + name + " Es Par")
    }
    else {
      println("El número " + name + " Es Impar")
    }
  }
  
  // 3. Dada la variable bird = "tweet", utiliza interpolación de string para imprimir  "Estoy escribiendo un tweet"
  val tweet = "tweet"
  println(s"Estoy escribiendo un $tweet")
  
  // 4. Dada la variable mensaje = "Hola luke yo soy tu padre!" utilza slilce para extraer
  // la secuencia "Luke"
  val mensaje = "Hola Luke yo soy tu padre!"
  println(mensaje.slice(5,9))
  
  // 5. Cuál es la diferencia en value y una varuiable en scala?
  // Los valores val son inmutables una vez asignados
  // Las variables var pueden ser reasignadas
  // Al reasignar debe usar el mismo tipo de datos
  
  // 6. Dada la tupla ((2,4,5),(1,2,3),(3.1416,23))
  val my_tupla = ((2,4,5),(1,2,3),(3.1416,23))
  println(my_tupla._3._1)
  }
}