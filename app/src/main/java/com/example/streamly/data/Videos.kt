package com.example.streamly.data

import kotlinx.serialization.Serializable

@Serializable
data class Videos(
    val videoUrl: String,
    val channelName: String,
    val views: Int,
    val subscribers: Int,
    val uploadTime: String?,
    val videoThumbnail: String?,
    val channelPhoto: String?,
    val videoDescription: String?,
    val videoTitle: String,
    val videoLikes: Int,
    val videoDislikes: Int
)
