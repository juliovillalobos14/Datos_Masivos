// 1. Escriber función que tome un entero y devuelva un booleano que indique
// si es par o no.
//Se declara una función que recibe un entero y devuelve un booleano
def numeropar(n: Int): Boolean = {
    //Este condicional verifica si el número es par o impar
    if(n % 2 == 0){
         return true
    }else{
        return false
    }
}
//Función igual a la anterior pero de menos líneas
def isEven(num:Int): Boolean = {
     return num%2 == 0
 }
 isEven(10)
numeropar(10)

// 2. Escribir una función que devuelva True si hay un número par dentro de
// una lista; de lo contrario devolver False
def listEvens(list:List[Int]): String ={
    //Es ciclo recorre la lista para ver si hay dentro un número par
    for(n <- list){
        //Este condicional verifica si es un número par
        if(n%2==0){
            println(s"$n is even")
        }else{
            println(s"$n is odd")
        }
    }
    return "Done"
}
//Se usan dos listas para verificar la función anterior
val l = List(1,2,3,4,5,6,7,8)
val l2 = List(4,3,22,55,7,8)
listEvens(l)
listEvens(l2)

// 3. Tomar una lista de enteros y calcular su suma. Sin embargo, los número siete
// tiene suerte y deben contarse dos veces, lo que significa que su valor
// seria 14 para la suma

def afortunado(list:List[Int]): Int={
    //Usamos una variable constante como cero
    var res=0
    //El ciclo recorre la lista
    for(n <- list){
        //Si un número es igual a 7 lo suma así mismo para que sea el doble
        if(n==7){
            res = res + 14
        }else{
            res = res + n
        }
    }
    return res
}
//Lista y llamada a la función
val af= List(1,7,7)
println(afortunado(af))

// 4. Dada una lista no vacía de enteros, devuelva verdadero si hay un lugar
// para dividir la lista de modo que la suma de los números en el otro
// lado. Por ejemplo,, dado la lista List(1,5,3,3) devolvería true, puede
// dividirlo en el medio. Otro ejemplo (7,3,4) devolvería true 3 + 4 = 7
// Recordar que solo necesita devolver el booleano, no el punto de índice dividido

//Función que recibe una lista de tipo Int y devuelve un booleano
def balance(list:List[Int]): Boolean={
    //Declaramos dos variables constantes con valor cero
    var primera = 0
    var segunda = 0
    //Hacemos una sumatoria de la lista
    segunda = list.sum

    //Este ciclo recorre la lista con el rango y largo de la lista
    for(i <- Range(0,list.length)){
        //Suma la primera lista con el valor
        primera = primera + list(i)
        //Resta la segunda lista con el valor
        segunda = segunda - list(i)

        //Si ambos valores son iguales devuelve como true
        if(primera == segunda){
            return true
        }
    }
    return false 
}

//Listas declaradas para probar la función
val bl = List(3,2,1)
val bl2 = List(2,3,3,2)
val bl3 = List(10,30,90)

balance(bl)
balance(bl2)
balance(bl3)

// 5. Dada una cadena, devuelva un booleano que indica si es o no un palíndromo. (El deletreado es lo mismo
// para adelante como para atrás)

def palindromo(palabra:String):Boolean ={
    //Si la palabra que recibe la función es igual usando la función de reverse entonces la devuelve
    return (palabra == palabra.reverse)
}

val palabra = "OSO"
val palabra2 = "ANNA"
val palabra3 = "JUAN"

println(palindromo(palabra))
println(palindromo(palabra2))
println(palindromo(palabra3))

