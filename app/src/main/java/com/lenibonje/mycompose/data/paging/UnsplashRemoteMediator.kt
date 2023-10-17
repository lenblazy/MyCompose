package com.lenibonje.mycompose.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.LoadType.APPEND
import androidx.paging.LoadType.PREPEND
import androidx.paging.LoadType.REFRESH
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.lenibonje.mycompose.data.local.UnsplashDatabase
import com.lenibonje.mycompose.data.remote.UnSplashApi
import com.lenibonje.mycompose.model.UnSplashImage
import com.lenibonje.mycompose.model.UnsplashRemoteKeys
import com.lenibonje.mycompose.utils.Constants.ITEMS_PER_PAGE
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class UnsplashRemoteMediator @Inject constructor(
    private val unsplashApi: UnSplashApi,
    private val unsplashDatabase: UnsplashDatabase
): RemoteMediator<Int, UnSplashImage>() {

    private val unsplashImageDao = unsplashDatabase.unsplashImageDao()
    private val unsplashRemoteKeysDao = unsplashDatabase.unsplashRemoteKeysDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UnSplashImage>
    ): MediatorResult {
        return try {
            val currentPage = when(loadType){
                REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage ?:
                    return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                    prevPage
                }
                APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage ?:
                    return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                    nextPage
                }
            }

            val response = unsplashApi.getAllImages(page = currentPage, perPage = ITEMS_PER_PAGE)
            val endOfPaginationReached = response.isEmpty()

            val prevPage = if (currentPage == 1) null else currentPage - 1
            val nextPage = if (endOfPaginationReached) null else currentPage + 1

            unsplashDatabase.withTransaction {
                if (loadType == REFRESH){
                    unsplashImageDao.deleteAllImages()
                    unsplashRemoteKeysDao.deleteAllRemoteKeys()
                }

                val keys = response.map {
                    UnsplashRemoteKeys(
                        id = it.id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }
                unsplashRemoteKeysDao.addAllRemoteKeys(keys)
                unsplashImageDao.addImages(response)
            }
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        }catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

    private fun getRemoteKeyForLastItem(state: PagingState<Int, UnSplashImage>): UnsplashRemoteKeys? {
        TODO("Not yet implemented")
    }

    private fun getRemoteKeyForFirstItem(state: PagingState<Int, UnSplashImage>): UnsplashRemoteKeys? {
        TODO("Not yet implemented")
    }

    private fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, UnSplashImage>): UnsplashRemoteKeys? {
        TODO("Not yet implemented")
    }


}