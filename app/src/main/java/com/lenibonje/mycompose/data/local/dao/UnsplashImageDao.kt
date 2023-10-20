package com.lenibonje.mycompose.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lenibonje.mycompose.model.UnSplashImage

@Dao
interface UnsplashImageDao {

    @Query("SELECT * FROM tbl_unsplash_image")
    fun getAllImages(): PagingSource<Int, UnSplashImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addImages(images: List<UnSplashImage>)

    @Query("DELETE FROM tbl_unsplash_image")
    fun deleteAllImages()

}
