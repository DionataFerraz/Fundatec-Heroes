package br.com.fundatec.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fundatec.App
import br.com.fundatec.profile.data.local.UserDao
import br.com.fundatec.profile.data.local.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class FHDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(): FHDatabase {
            return Room.databaseBuilder(
                App.context,
                FHDatabase::class.java,
                "fh.database"
            ).build()
        }
    }
}
