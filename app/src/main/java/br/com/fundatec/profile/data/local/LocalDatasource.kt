package br.com.fundatec.profile.data.local

import android.util.Log
import br.com.fundatec.database.FHDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LocalDatasource {
    private val database: FHDatabase by lazy {
        FHDatabase.getInstance()
    }

    suspend fun save() {
        return withContext(Dispatchers.IO) {
            database.userDao().insertUser(
                UserEntity(
                    name = "Dionata",
                    email = "dionataferraz@gmail.com",
                    password = "123456"
                )
            )

            Log.e("teste", "${ database.userDao().getUser()}")
        }
    }
}