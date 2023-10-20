package com.lenibonje.mycompose.model


import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @Embedded
    val links: UserLinks,
    val username: String
)