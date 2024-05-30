package com.eniecole.mod6datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesRepository(val context : Context) {
    private val Context.dataStore by preferencesDataStore(
    name = "prefutilisateur")

    companion object{
        private val KEY_PRIMARY_COLOR = stringPreferencesKey("key_primary_color")
        //private val KEY_ID_USER = intPreferencesKey("key_id_user")
    }

    val primaryColor : Flow<String?> = context.dataStore.data.map { pref->
        pref[KEY_PRIMARY_COLOR]
    }
    suspend fun setPrimaryColor(primaryColor : String){
        context.dataStore.edit { pref ->
            pref[KEY_PRIMARY_COLOR] = primaryColor
        }
    }

}