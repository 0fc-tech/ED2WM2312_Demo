package com.eniecole.mod2variables

fun main() {
    //Inférence de type: Kotlin sait que idLastProduct est Long grâce au "L"
    val idLastProduct = 120L
    //Impossible de redéfinir une val
    //idLastProduct = 0

    //Constante appelée orderName de type String Nullable (?)
    val orderName :String? = null
    //String interpolation avec une valeur nulle
    val emailObject = "This order is named $orderName"

    var subtotal :Int? = null
    //On utilise ?. pour éxécuter une méthode sur une instance nullable
    // ?. pour éxécuter une méthode "Safe Call" sur une instance nullable => On vérifie qu'elle
    // n'est pas nulle pour éxécuter la méthode
    val totalPlusTaxes = subtotal?.times(1.2)

    var qtyInCart : Int? = null
    //On utilise ?: lorsqu'on veut retourner une valeur quand
    // ce qu'il y a gauche de l'opérateur est null
                            //Opérateur Elvis
    var qtyBilled = qtyInCart?.plus(8) ?: 0
    var qtyBilled2 = if(qtyInCart != null){
        qtyInCart + 8
    }else{
        0
    }
    //Ici, si qtyInCart est null, qtyBilled aura pour valeur 0
}
