package uz.itschool.phone.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Email(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var email:String,
    @ColumnInfo("contact_id")
    var contactId: Int,
)