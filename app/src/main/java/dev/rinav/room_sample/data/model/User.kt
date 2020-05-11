package dev.rinav.room_sample.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Rinav Gangar <rinav.dev> on 11/5/20.
 * Agrahyah Technologies Pvt Ltd
 * rinav4all@gmail.com
 */
@Entity
data class User(

    val username: String,

    @ColumnInfo(name = "password_hash")
    val passwordHash: Int,

    val info: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}