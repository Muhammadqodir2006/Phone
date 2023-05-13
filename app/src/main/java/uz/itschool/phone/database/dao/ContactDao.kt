package uz.itschool.phone.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import uz.itschool.phone.database.entity.Contact

@Dao
interface ContactDao {
    @Query("select * from contacts")
    fun getAllContacts():List<Contact>

    @Insert
    fun addContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)
}