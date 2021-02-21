package com.taein.campustalkRecommendChatRoomPaging3Test.view

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.taein.campustalkRecommendChatRoomPaging3Test.data.model.OpenChatRoomDto
import com.taein.campustalkRecommendChatRoomPaging3Test.databinding.ItemRecommendedChatRoomBinding
import com.taein.campustalkRecommendChatRoomPaging3Test.view.viewholder.RecommendedChatRoomViewHolder


class RecommendedChatRoomPagingAdapter
    : PagingDataAdapter<OpenChatRoomDto, RecommendedChatRoomViewHolder>(CHAT_ROOM_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedChatRoomViewHolder {
        val binding = ItemRecommendedChatRoomBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendedChatRoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendedChatRoomViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        private val CHAT_ROOM_COMPARATOR = object : DiffUtil.ItemCallback<OpenChatRoomDto>() {
            override fun areContentsTheSame(oldItem: OpenChatRoomDto, newItem: OpenChatRoomDto): Boolean =
                oldItem.chatIdx == newItem.chatIdx

            override fun areItemsTheSame(oldItem: OpenChatRoomDto, newItem: OpenChatRoomDto): Boolean =
                oldItem.chatIdx == newItem.chatIdx
        }
    }
}