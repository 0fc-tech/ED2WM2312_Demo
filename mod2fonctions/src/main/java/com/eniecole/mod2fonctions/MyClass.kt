package com.eniecole.mod2fonctions

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun canStartCar() : Boolean {
    val vitesseMoteur = 0
    val SoCVehicule = 98
    return SoCVehicule> 2
}
fun LocalDateTime.showDateTimeInFrench(): String {
    //Création format conversionde date pour
    val formatter = DateTimeFormatter.ofPattern(
        "'le' d MMMM 'à' HH'h'mm", Locale.FRENCH)
    // Formatage du LocalDateTime avec le format donnée
    return this.format(formatter)
}
fun main() {
    val aujourdhui = LocalDateTime.now()
    println(aujourdhui.showDateTimeInFrench())
    val listArticles = listOf(12L,123L,13L,14L,90L,100L)
    val listA = listOf<String>()
    val listB = listOf<String>("sdf")
    val listC = listOf<String>("sdf","sdf","sfsdéf","sdfsdfgsgr")
    println(concatenate(listArticles, separator = ":"))
    println(addition(1,2,4,6,3))
    println(addition())
    println(addition(1))
    println(addition(1,907,78,6578,87,98))
}
fun addition(vararg elements: Int) : Int{
    var sum = 0
    for (element in elements) {
        sum += element
    }
    return sum
}
//Fonction générique
fun <T> concatenate(list: List<T>, separator: String = ", "): String { val stringBuilder = StringBuilder()
    for ((index, item) in list.withIndex()) {
        //Si ce n'est pas le premier élément, ajouter le séparateur
        if (index > 0) stringBuilder.append(separator)
        stringBuilder.append(item)
    }
    return stringBuilder.toString()
}
fun collections() {
    val listProducts = mutableListOf(
        "Bureau avec vérins",
        "Chaise de travail Herman Miller",
        "Bureau Steelcase chêne",
        "Bureau Ikea SEKØVA",
        "Bureau blanc",
        "Chaise Think V1",
        "Armoire métal haute",
    )
    //Ajout avec l'opérateur +=
    listProducts += "Armoire basse"
    //ou avec la méthode add
    listProducts.add("Canapé accueil")
    listProducts.filter { it.startsWith("Bureau") }
                .sortedBy { it }
                .count { it.contains("Ikea") }
}