package com.eniecole.mod4notemagasin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RatingViewModel : ViewModel(){
    var state by mutableStateOf<RatingState>(RatingState.Initial)
        private set
    fun updateRating(note : Int?){
        if (note != null) {
            if(note>=8)
                state = RatingState.Success(note)
            else
                state = RatingState.RequestFeedback(note)
        }
    }
}

sealed class RatingState{
    object Initial : RatingState()
    class Success(val note : Int?): RatingState()
    class RequestFeedback(val note : Int?): RatingState()
    object Finished : RatingState()
}