package com.lenibonje.mycompose.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lenibonje.mycompose.model.UnSplashImage

@Dao
interface UnsplashImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(images: List<UnSplashImage>)

    @Query("SELECT * FROM tbl_unsplash_image")
    fun getAllImages(): PagingSource<Int, UnSplashImage>

    @Query("DELETE FROM tbl_unsplash_image")
    suspend fun deleteAllImages()

}
