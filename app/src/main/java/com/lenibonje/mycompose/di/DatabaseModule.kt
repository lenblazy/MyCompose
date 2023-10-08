package com.lenibonje.mycompose.di

import androidx.room.Room
import com.lenibonje.mycompose.data.PersonDatabase
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
    fun provideDatabase(
        @ApplicationContext context: android.content.Context
    ) = Room.databaseBuilder(
        context = context,
        klass = PersonDatabase::class.java,
        name = "my_database"
    ).createFromAsset("database/my_database.db").build()

    @Singleton
    @Provides
    fun providePersonDao(
        database: PersonDatabase
    ) = database.personDao()

}