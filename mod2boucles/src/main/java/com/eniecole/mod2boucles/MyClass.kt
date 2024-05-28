package com.eniecole.mod2boucles
fun main1() {
    val listClient = listOf("John Doe", "Peter Parker","Harry Potter", "Tony Stark")
    for(client in listClient){
        println("Bienvenu $client,\n Notre solution de paiement est conçue pour vous")
    }
    val list = listOf(1,2,3,4,5,6,7,8,9,10,"ksdflg","dsgmlfsd","sdglm",
        1.3)

}
fun main(){
    val secretNumber = (1..11).random()
    var guess: Int
    var attempts = 0

    println("Devinez le nombre entre 1 et 10!")

    while (true) {
        print("Entrez votre nombre: ")
        guess = readln().toInt()
        attempts++

        if (guess == secretNumber) {
            println("Bravo! vous avez trouvé $secretNumber en $attempts tentatives.")
            break
        } else {
            println("Essayez encore.")
        }
    }
}
