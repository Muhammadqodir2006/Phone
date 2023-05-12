package uz.itschool.phone.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Group (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo("group_name")
    var groupName: String,
)