package com.eniecole.mod2poo

interface Mangeable {
    fun manger()=println("Miam")
}
class Pain(val type: String):Mangeable{
    override fun manger() {
        super.manger()
        println("C'est super bon c'est du $type")
    }
}

fun main() {
    val pain = Pain("Complet")
    pain.manger()
}
