package com.lenibonje.mycompose.data.repository

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lenibonje.mycompose.data.local.UnsplashDatabase
import com.lenibonje.mycompose.data.paging.SearchPagingSource
import com.lenibonje.mycompose.data.paging.UnsplashRemoteMediator
import com.lenibonje.mycompose.data.remote.UnSplashApi
import com.lenibonje.mycompose.model.UnSplashImage
import com.lenibonje.mycompose.utils.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class Repository @Inject constructor(
    private val unsplashDatabase: UnsplashDatabase,
    private val unsplashApi: UnSplashApi
) {

    fun getAllImages(): Flow<PagingData<UnSplashImage>> {
        Log.d("HAHAHA", "getAllImages REPOSITORY : CALLED")

        val pagingSourceFactory = {
            Log.d("HAHAHA", "getAllImages pagingSourceFactory: CALLED")

            unsplashDatabase.unsplashImageDao().getAllImages()
        }
        return Pager(
            config = PagingConfig(
                pageSize = ITEMS_PER_PAGE
            ),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow.flowOn(Dispatchers.IO)
    }

    fun searchImages(query: String): Flow<PagingData<UnSplashImage>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchPagingSource(unsplashApi = unsplashApi, query = query)
            }
        ).flow.flowOn(Dispatchers.IO)
    }

}