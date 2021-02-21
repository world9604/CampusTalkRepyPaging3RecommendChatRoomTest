package com.taein.paging3test.data.rx

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.flowable
import com.taein.campustalkRecommendChatRoomPaging3Test.data.model.OpenChatRoomDto
import io.reactivex.Flowable

class GetRcommendChatRoomsRxRepositoryImpl(private val pagingSource: GetChatRoomsRxPagingSource):
    GetRcommendChatRoomsRxRepository {

    override fun getReplys(): Flowable<PagingData<OpenChatRoomDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 30,
                prefetchDistance = 5,
                initialLoadSize = 40),
            pagingSourceFactory = { pagingSource }
        ).flowable
    }
}