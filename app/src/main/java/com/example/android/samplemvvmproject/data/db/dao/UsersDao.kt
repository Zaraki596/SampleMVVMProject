package com.example.android.samplemvvmproject.data.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import androidx.room.Update
import com.example.android.samplemvvmproject.data.db.entity.Users

@Dao
interface UsersDao {

    @Insert(onConflict = IGNORE)
    suspend fun insert(user: Users)

    @Update
    fun update(user: Users)

    /**
     * If changes is reflected the UI automatically updates
     */
    @Query("SELECT * FROM Users ORDER BY first ASC")
    fun getAllUsers(): LiveData<List<Users>>

}