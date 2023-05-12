package uz.itschool.phone.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo("first_name")
    var firstName: String,
    @ColumnInfo("last_name")
    var lastName:String,
    @ColumnInfo("group_id")
    var groupId:Int
)