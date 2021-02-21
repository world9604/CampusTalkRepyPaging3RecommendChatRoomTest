package com.taein.campustalkRecommendChatRoomPaging3Test.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RecommendedChatRoomPaging (
    @Expose
    @SerializedName("items")
    val chatRoomList: List<OpenChatRoomDto> = mutableListOf(),

    // "page": 1,
    @Expose
    @SerializedName("page")
    val page: Int,

    // "count": 20,
    @Expose
    @SerializedName("count")
    val count: Int,

    // "total_count": 83,
    @Expose
    @SerializedName("total_count")
    val total_count: Int,

    // "last": 5
    @Expose
    @SerializedName("last")
    val last: Int

) : Serializable