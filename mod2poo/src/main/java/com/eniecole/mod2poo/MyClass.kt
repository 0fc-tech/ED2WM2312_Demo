package com.eniecole.mod2poo

data class Travail(
    val intitulePoste: String,
    val salaireAnnuel: Int,
    var isCadre: Boolean,
    var ville: String?
)
fun main() {
    val developpeurNantais = Travail("Développeur", 34000, true, "Nantes")
    val designerTeleTravail = Travail("Designer", 44000, true, null)
    val dirigeantESN = Travail("PDG",74000,true,"Paris")
    AppareilBluetooth("00:11:22:33:44:55").connecter()
}
class AppareilBluetooth(val macAdress:String){
    fun connecter(){}
}