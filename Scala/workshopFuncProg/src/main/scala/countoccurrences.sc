def countOccurrences(list: List[Int], num: Int): Int = {
  list match {
    case Nil => 0 // Caso base: lista vacía, retorna 0
    case head :: tail =>
      // Verificamos si el primer elemento es igual a num, de ser así sumamos 1
      // Luego, hacemos recursión con la cola de la lista
      if (head == num) 1 + countOccurrences(tail, num)
      // De lo contrario hacemos recursión con la cola de la lista sin sumar nada
      else countOccurrences(tail, num)
  }
}

// Pruebas
val listaVacia = List()
val listaUno = List(5)
val listaDos = List(3, 3)
val listaCinco = List(1, 2, 3, 4, 5)
val listaMuchos = List(2, 2, 3, 2, 4, 2, 5, 2)

println("Pruebas:")
println(s"Cantidad de veces que aparece 2 en la lista $listaVacia: ${countOccurrences(listaVacia, 2)}")
println(s"Cantidad de veces que aparece 5 en la lista $listaUno: ${countOccurrences(listaUno, 5)}")
println(s"Cantidad de veces que aparece 3 en la lista $listaDos: ${countOccurrences(listaDos, 3)}")
println(s"Cantidad de veces que aparece 4 en la lista $listaCinco: ${countOccurrences(listaCinco, 4)}")
println(s"Cantidad de veces que aparece 2 en la lista $listaMuchos: ${countOccurrences(listaMuchos, 2)}")