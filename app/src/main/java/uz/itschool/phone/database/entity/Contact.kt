package uz.itschool.phone.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    @ColumnInfo("first_name")
    var firstName: String,
    @ColumnInfo("last_name")
    var lastName:String,
    var number:String
)