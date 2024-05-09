package com.example.streamly.utility

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit


fun getTimeDifference(timeStamp: String): String {
    val timeInMillis = convertTimestampToLong(timeStamp)
    val currentTimeMillis = System.currentTimeMillis()
    val differenceInMillis = currentTimeMillis - timeInMillis

    val seconds = TimeUnit.MILLISECONDS.toSeconds(differenceInMillis)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(differenceInMillis)
    val hours = TimeUnit.MILLISECONDS.toHours(differenceInMillis)
    val days = TimeUnit.MILLISECONDS.toDays(differenceInMillis)

    return when {
        seconds < 60 -> "$seconds seconds ago"
        minutes < 60 -> "$minutes minutes ago"
        hours < 24 -> "$hours hours ago"
        else -> "$days days ago"
    }
}

fun convertTimestampToLong(timestampString: String): Long {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val date: Date = dateFormat.parse(timestampString) ?: Date()
    return date.time
}


fun formatDate(timestamp: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
    val date = inputFormat.parse(timestamp) ?: Date()
    return outputFormat.format(date)
}