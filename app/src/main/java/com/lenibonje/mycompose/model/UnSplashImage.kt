package com.lenibonje.mycompose.model


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lenibonje.mycompose.utils.Constants.TBL_UNSPLASH_IMAGE
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity (tableName = TBL_UNSPLASH_IMAGE)
data class UnSplashImage(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @Embedded
    val urls: Urls,
    val likes: Int,
    @Embedded
    val user: User,
)