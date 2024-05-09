package com.example.streamly.supabase.api

import com.example.streamly.data.Videos
import com.example.streamly.supabase.SupabaseClientProvider
import io.github.jan.supabase.postgrest.from

class VideoFetchService {
    suspend fun fetchVideos() : List<Videos> {
        val supabase = SupabaseClientProvider.getSupabaseClient()
        val response = supabase
            .from("videos")
            .select()
            .decodeList<Videos>()
        return response
    }
}