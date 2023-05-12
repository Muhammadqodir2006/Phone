package uz.itschool.phone.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Number(
    @PrimaryKey(autoGenerate = true)
    var id :Int,
    var number: Int,
    @ColumnInfo("contact_id")
    var contactId: Int,
    )