package com.eniecole.mod4gestioninteraction

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class RecetteViewModel : ViewModel() {
    var nbPersonnes by mutableIntStateOf(1)
        private set
    var nbOeufs by mutableIntStateOf(1)
        private set
    var gFarine by mutableIntStateOf(100)
        private set

    fun incNbPersonnes() {
        nbPersonnes+=1
        nbOeufs = nbPersonnes / 2
        gFarine = 70 * nbPersonnes
    }
    fun decNbPersonnes() {
        if(nbPersonnes==1)
            return
        nbPersonnes-=1
        nbOeufs = nbPersonnes / 2
        gFarine = 70 * nbPersonnes
    }


}