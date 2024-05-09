package com.example.streamly.utility

fun formatSubscriberCount(subscriberCount: Int): String {
    return when {
        subscriberCount >= 1_000_000_000 -> "${subscriberCount / 1_000_000_000}B"
        subscriberCount >= 1_000_000 -> "${subscriberCount / 1_000_000}M"
        subscriberCount >= 1_000 -> "${subscriberCount / 1_000}K"
        else -> subscriberCount.toString()
    }
}