package com.taein.paging3test.data.rx

import android.util.Log
import androidx.paging.rxjava2.RxPagingSource
import com.taein.campustalkRecommendChatRoomPaging3Test.data.model.OpenChatRoomDto
import com.taein.campustalkRecommendChatRoomPaging3Test.data.model.RecommendedChatRoomPaging
import com.taein.paging3test.data.TMDBService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class GetChatRoomsRxPagingSource(
    private val service: TMDBService,
    private val page: Int,
    private val count: Int
) : RxPagingSource<Int, OpenChatRoomDto>() {

    private val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6Im5hdmVyXzU5NDIzMjc2IiwiaWR4IjoyNzg5MSwibmlja25hbWUiOiLslbzsiJjsmKQiLCJlbWFpbCI6Indpbm5lcl93b3JsZEBuYXZlci5jb20iLCJ1cGRhdGVkX2F0IjoxNjAwNzQ5ODQ3MDAwLCJ0aW1lIjoxNjA5MjI0MzQwNzQ1LCJpYXQiOjE2MDkyMjQzNDAsImV4cCI6MTY5NTYyNDM0MH0.3sDgGt0Q5-nJJ6KBzDG57LL_xJIbkOjXNnOPFu8lgNk"
    private val privateUniv = 1

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, OpenChatRoomDto>> {
        val position = params.key ?: 1

        Log.d("loadPaging3", "position : ${position}, count : ${count}")
        return service.getRecommendedChatRoom(token, position, count, privateUniv)
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(it, (position * count)) }
            .onErrorReturn { LoadResult.Error(it) }
    }

    private fun toLoadResult(data: RecommendedChatRoomPaging, position: Int): LoadResult<Int, OpenChatRoomDto> {
        Log.d("loadPaging3", "position : ${position}, total cnt : ${data.total_count}")
        return LoadResult.Page(
            data = data.chatRoomList,
//            prevKey = if (position <= 1) null else position - 1,
            prevKey = null, // 이전 데이터는 불러 오지 않는다.
            nextKey = if (position >= data.total_count) {
                null
            } else {
                position + 1
            }
        )
    }
}