package com.taein.campustalkRecommendChatRoomPaging3Test.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.taein.campustalkRecommendChatRoomPaging3Test.data.model.OpenChatRoomDto
import com.taein.campustalkRecommendChatRoomPaging3Test.databinding.ItemRecommendedChatRoomBinding

class RecommendedChatRoomViewHolder(val binding: ItemRecommendedChatRoomBinding)
: RecyclerView.ViewHolder(binding.root) {

    fun bind(chatRoom: OpenChatRoomDto) {
        binding.chatRoom = chatRoom
    }
}