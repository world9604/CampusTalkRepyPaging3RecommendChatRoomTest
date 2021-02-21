package com.taein.paging3test.data.rx

import androidx.paging.PagingData
import com.taein.campustalkRecommendChatRoomPaging3Test.data.model.OpenChatRoomDto
import io.reactivex.Flowable

interface GetRcommendChatRoomsRxRepository {
    fun getReplys(): Flowable<PagingData<OpenChatRoomDto>>
}