
        val Datos = List(3,10,15)
        val met = 3.2808
        val dll = 18.0
        val mill = 0.62137
        for(name <- Datos) {
          println(name + " Pies es igual en metros a: " + (name / met))
        }
        for(name <- Datos) {
          println(name + " Dollares a pesos son:  " + (name * dll))
        }
        for(name <- Datos) {
          println(name + " Millas son en kilometros: " + (name * mill))
        }
  