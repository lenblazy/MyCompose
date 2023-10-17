package com.lenibonje.mycompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lenibonje.mycompose.model.UnSplashImage
import com.lenibonje.mycompose.model.UnsplashRemoteKeys

@Database(
    entities = [
        UnSplashImage::class,
        UnsplashRemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao

    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}