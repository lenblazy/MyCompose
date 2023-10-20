package com.lenibonje.mycompose.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lenibonje.mycompose.utils.Constants.TBL_UNSPLASH_REMOTE_KEYS

@Entity(tableName = TBL_UNSPLASH_REMOTE_KEYS)
data class UnsplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @ColumnInfo(name = "prev_page")
    val prevPage: Int?,
    @ColumnInfo(name = "next_page")
    val nextPage: Int?,
)
