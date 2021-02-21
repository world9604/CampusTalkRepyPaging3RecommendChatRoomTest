package com.taein.campustalkRecommendChatRoomPaging3Test.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class OpenChatRoomDto (
        //"chat_idx": 3,
        @Expose
        @SerializedName("chat_idx")
        val chatIdx: Long,

        //"room_idx": 37,
        @Expose
        @SerializedName("room_idx")
        val roomIdx: Int,

        //"master_idx": 19288,
        @Expose
        @SerializedName("master_idx")
        val masterIdx: Int,

        //"master_nickname": "옼돜맨",
        @Expose
        @SerializedName("master_nickname")
        val masterNickname: String,

        //"profile_image": null,
        @Expose
        @SerializedName("profile_image")
        val profileImage: String,

        //"img_key": "development/campus_talk/group/thumbnail_img/UZE2KZGEFW53I7JVU4L0.jpeg"
        @Expose
        @SerializedName("img_key")
        val imgKey: String,

        //"title": "zzz",
        @Expose
        @SerializedName("title")
        val title: String,

        //"tag": "eeeee",
        @Expose
        @SerializedName("tag")
        val tag: String,

        //"like_cnt": 1,
        @Expose
        @SerializedName("like_cnt")
        val likeCnt: Int,

        //"last_used_at": 1604465939000,
        @Expose
        @SerializedName("last_used_at")
        val lastUsedAt: Double,

        // 0: 내가 들가있는 그룹채팅
        // 1: 내가 들가있는 다른사람 1대1채팅
        // 2: 내가 만든 1대1 채팅방
        @Expose
        @SerializedName("sort")
        val sort: Int = 0,

        // for RcommendedChatRoom
        // "mem_cnt": 7,
        @Expose
        @SerializedName("mem_cnt")
        val memCnt: Int = 7,

        // "nickname": "옼돜맨",
        @Expose
        @SerializedName("nickname")
        val nickname: String

) : Serializable