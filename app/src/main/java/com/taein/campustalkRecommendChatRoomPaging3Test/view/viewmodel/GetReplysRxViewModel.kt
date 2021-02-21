package com.taein.paging3test.view.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.rxjava2.cachedIn
import com.taein.campustalkRecommendChatRoomPaging3Test.data.model.OpenChatRoomDto
import com.taein.paging3test.data.rx.GetRcommendChatRoomsRxRepository
import io.reactivex.Flowable

class GetReplysRxViewModel(private val repository: GetRcommendChatRoomsRxRepository) : ViewModel() {

    fun getReplys(): Flowable<PagingData<OpenChatRoomDto>> {
        return repository
            .getReplys()
            .map { pagingData ->
                pagingData.filter { it.chatIdx != null }
            }
            .cachedIn(viewModelScope)
    }
}