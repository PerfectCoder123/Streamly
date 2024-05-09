package com.example.streamly.supabase

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.serializer.KotlinXSerializer
import kotlinx.serialization.json.Json

object SupabaseClientProvider {
    private val supabaseClient: SupabaseClient  =
        createSupabaseClient(
            supabaseUrl = "",
            supabaseKey = ""
        ){
            install(Postgrest)
            defaultSerializer = KotlinXSerializer(Json)
        }


    fun getSupabaseClient(): SupabaseClient {
        return supabaseClient
    }
}

