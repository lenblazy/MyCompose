package com.lenibonje.mycompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lenibonje.mycompose.model.UnsplashRemoteKeys

@Dao
interface UnsplashRemoteKeysDao {

    @Query("SELECT * FROM tbl_unsplash_remote_keys WHERE id = :id")
    suspend fun getRemoteKeys(id: String): UnsplashRemoteKeys

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<UnsplashRemoteKeys>)


    @Query("DELETE FROM tbl_unsplash_remote_keys")
    suspend fun deleteAllRemoteKeys()

}