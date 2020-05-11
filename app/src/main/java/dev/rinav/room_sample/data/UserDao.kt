package dev.rinav.room_sample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.rinav.room_sample.data.model.User

/**
 * Created by Rinav Gangar <rinav.dev> on 11/5/20.
 * Agrahyah Technologies Pvt Ltd
 * rinav4all@gmail.com
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM USER WHERE username = :username")
    suspend fun getUser(username: String): User?

    @Query("DELETE FROM user WHERE id = :id")
    suspend fun deleteUser(id: Long)
}