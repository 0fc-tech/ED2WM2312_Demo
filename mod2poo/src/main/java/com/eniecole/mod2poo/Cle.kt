package com.eniecole.mod2poo

open class Cle() {
    open fun ouvrirPorte(){
        println("ouverture de porte") }
    fun fermerPorte(){
        println("fermerture de porte") }
}

class CleVoiture() : Cle() {
    override fun ouvrirPorte() {
        println("ouverture de toutes les portes") }
    fun ouvertureCoffre(){
        println("ouverture coffre uniquement")
    }
}

fun main() {
    val cleBMW = CleVoiture()
    cleBMW.ouvertureCoffre()
    cleBMW.ouvrirPorte()
    cleBMW.fermerPorte()
    val cleChateau = Cle()
    cleChateau.ouvrirPorte()
}