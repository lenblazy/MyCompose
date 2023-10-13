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
    @SerialName("id")
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @SerialName("urls")
    @Embedded
    val urls: Urls,
    @SerialName("likes")
    val likes: Int,
    @SerialName("user")
    @Embedded
    val user: User,
)