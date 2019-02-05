object Practica3 {
  def main(args: Array[String]): Unit = {
    import scala.collection.mutable.MutableList
    
    // 1. Crea una lista llamada "lista" con los elementos "rojo", "blanco", "negro"
    val lista = MutableList("Rojo", "Blanco", "Negro")
    println(lista)
    
    // 2. Añadir 5 elementos más a la lista: "verde","amarrillo","azul","naranja","perla"
    lista ++= MutableList("verde","amarrillo","azul","naranja","perla")
    println(lista)
    
    // 3. Traer los elementos de una "lista" "verde", "amarrillo", "azul"
    println(lista(3))
    println(lista(4))
    println(lista(5))
    
    // 4. Crea un arreglo de numero en rango del 1-1000 en pasos de 5 en 5
    var arreglo = Array.range(0, 1000, 5)
    println(arreglo(5))
    
    //5. Cuales son los elementos unicos 
    //de la lista Lista(1,3,3,4,6,7,3,7) utilice conversion a conjuntos
    
    val Lista = List(1,3,3,4,6,7,3,7)
    println(Lista.toSet)
    
    // 6. Crea una mapa mutable llamado nombres que contenga los siguiente
   // "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
    val mutmap = collection.mutable.Map(("Jose",20),("Luis",24),("Ana",23),("Susana",27))
    // a . Imprime todas la llaves del mapa
    println(mutmap)
    
    // 7. Agrega el siguiente valor al mapa("Miguel", 23)
    mutmap += ("Miguel" -> 23)
    println(mutmap)
  }
}