package com.lenibonje.mycompose.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lenibonje.mycompose.data.local.UnsplashDatabase
import com.lenibonje.mycompose.data.paging.UnsplashRemoteMediator
import com.lenibonje.mycompose.data.remote.UnSplashApi
import com.lenibonje.mycompose.model.UnSplashImage
import com.lenibonje.mycompose.utils.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val unsplashDatabase: UnsplashDatabase,
    private val unsplashApi: UnSplashApi
) {

    @OptIn(ExperimentalPagingApi::class)
    fun getAllImages(): Flow<PagingData<UnSplashImage>>{
        val pagingSourceFactory = { unsplashDatabase.unsplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(
                pageSize = ITEMS_PER_PAGE
            ),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

}