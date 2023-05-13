package uz.itschool.phone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.itschool.phone.database.dao.ContactDao
import uz.itschool.phone.database.entity.Contact

@Database(entities = [Contact::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getContactDao():ContactDao

    companion object{
        var instance : AppDatabase? = null

        fun getInstance(context: Context):AppDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "app_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}