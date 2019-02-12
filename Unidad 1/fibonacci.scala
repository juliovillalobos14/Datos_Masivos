// Algoritmo 1 Versión recursiva descendente
def algoritmo1(n: Int): Int = {

    if(n < 2) {
        return n
    }
    else {
        return algoritmo1(n - 1) + algoritmo1(n - 2)
    }

}

for(a <- 1 to 10) {
    println(algoritmo1(a))
}

//Algoritmo 2 Versión con fórmula explícita
def algoritmo2(n: Double): Double = {
    if(n < 2) {
        return n
    }
    else {
        var b: Double = ((1 + math.sqrt(5)) / 2)
        var j: Double = ((math.pow(b,n) - (1 - b)) / math.sqrt(5))
        return j
    }
}

for(a <- 1 to 10) {
    println(algoritmo2(a))
}

//Algoritmo 3 Versión iterativa Complejidad O(n)
def algoritmo3(n: Int): Int = {
    var a = 0
    var b = 1
    var c = 0
    for(k <- 1 to n) {
        c = b + a
        a = b
        b = c
    }
    return a
}

for(a <- 1 to 10) {
    println(algoritmo3(a))
}

//Algoritmo 4 Versión iterativa 2 variables Complejidad O(n)
def algoritmo4(n: Int): Int = {
    var a = 0
    var b = 1
    for(k <- 1 to n) {
        b = b + a
        a = b - a
    }
    return a
}

for(a <- 1 to 10) {
    println(algoritmo4(a))
}

//Algoritmo 5 Versión iterativa vector Complejidad O(n)
//def algoritmo5(n: Int): Int = {
//    if(n < 2) {
//        return n
//    }
//    else {
        
//    }
//}

