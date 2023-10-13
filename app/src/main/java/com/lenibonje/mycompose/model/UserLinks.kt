package com.lenibonje.mycompose.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserLinks(
    @SerialName("html")
    val html: String,
)