package com.adrena.commerce.paging3.data

import androidx.lifecycle.ViewModelProvider
import com.taein.paging3test.data.TMDBService
import com.taein.paging3test.data.rx.GetChatRoomsRxPagingSource
import com.taein.paging3test.data.rx.GetRcommendChatRoomsRxRepositoryImpl
import com.taein.paging3test.view.viewmodel.GetRecommendChatRoomRxViewModelFactory

object Injection {

    fun provideRxViewModel(): ViewModelProvider.Factory {
        val pagingSource =
            GetChatRoomsRxPagingSource(
                service = TMDBService.create(),
                page = 1,
                count = 20
            )

        val repository =
            GetRcommendChatRoomsRxRepositoryImpl(
                pagingSource = pagingSource
            )

        return GetRecommendChatRoomRxViewModelFactory(
            repository
        )
    }
}