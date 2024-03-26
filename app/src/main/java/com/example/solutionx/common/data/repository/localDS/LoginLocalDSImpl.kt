package com.example.solutionx.common.data.repository.localDS

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.solutionx.features.login.data.models.UserEntity
import com.example.solutionx.common.domain.repository.localDS.ILoginLocalDS
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map


val Context.dataStore: DataStore<Preferences> by preferencesDataStore("login")

val KEY_TOKEN = stringPreferencesKey("key_token")
val KEY_ID = stringPreferencesKey("key_id")
val KEY_NAME = stringPreferencesKey("key_name")
val KEY_EMAIL = stringPreferencesKey("key_email")
val KEY_PHONE = stringPreferencesKey("key_phone")

internal class LoginLocalDSImpl(private val context: Context? = null) : ILoginLocalDS {

    override suspend fun saveUser(userEntity: UserEntity) {
        context?.dataStore?.edit { preferences ->
            preferences[KEY_TOKEN] = userEntity.accessToken
            preferences[KEY_ID] = userEntity.id
            preferences[KEY_NAME] = userEntity.name
            preferences[KEY_EMAIL] = userEntity.email
            preferences[KEY_PHONE] = userEntity.phoneNumber
        }
    }

    override suspend fun getUser(): UserEntity {
        val preferences = context?.dataStore?.data?.first()

        val token = preferences?.get(KEY_TOKEN) ?: ""
        val id = preferences?.get(KEY_ID) ?: ""
        val name = preferences?.get(KEY_NAME) ?: ""
        val email = preferences?.get(KEY_EMAIL) ?: ""
        val phone = preferences?.get(KEY_PHONE) ?: ""

        return UserEntity(token, id, name, email, phone)


//        return context!!.dataStore.data.map {
//            val token = it[KEY_TOKEN] ?: ""
//            val id = it[KEY_ID] ?: ""
//            val name = it[KEY_NAME] ?: ""
//            val email = it[KEY_EMAIL] ?: ""
//            val phone = it[KEY_PHONE] ?: ""
//            UserEntity(token, id, name, email, phone)
//        }


//        val preferences = context.dataStore.data.first()
//        val token = preferences[KEY_TOKEN]
//        val id = preferences[KEY_ID]
//        val name = preferences[KEY_NAME]
//        val email = preferences[KEY_EMAIL]
//        val phone = preferences[KEY_PHONE]
//
//        return UserEntity(
//            token.toString(),
//            id.toString(),
//            name.toString(),
//            email.toString(),
//            phone.toString()
//        )
    }
}