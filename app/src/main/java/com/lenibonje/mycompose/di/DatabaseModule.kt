package com.lenibonje.mycompose.di

import android.content.Context
import androidx.room.Room
import com.lenibonje.mycompose.data.local.UnsplashDatabase
import com.lenibonje.mycompose.utils.Constants.UNSPLASH_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideUnsplashDatabase(
        @ApplicationContext context: Context
    ): UnsplashDatabase {
        return Room.databaseBuilder(
            context = context,
            UnsplashDatabase::class.java,
            UNSPLASH_DB
        ).build()
    }

}