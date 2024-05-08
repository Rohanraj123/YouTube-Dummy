package com.example.youtubedemo.di

import android.app.Application
import android.content.Context
import com.example.youtubedemo.data.repository.VideRepositoryImpl
import com.example.youtubedemo.data.repository.VideoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import javax.inject.Singleton

private var SUPA_BASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Ind4dW52dWx5eW9yZGppZ3FvYWhwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTQ5NjE3ODQsImV4cCI6MjAzMDUzNzc4NH0.AJtFf_HNUO91m7yy-IGTM-8JicccUWAs1Y2vNqnwhoY"
private var SUPA_BASE_URL = "https://wxunvulyyordjigqoahp.supabase.co"

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideSupabaseClient(context: Context): SupabaseClient {
        return createSupabaseClient(
            supabaseKey = SUPA_BASE_KEY,
            supabaseUrl = SUPA_BASE_URL
        ) {
            install(Postgrest)
        }
    }

    @Provides
    @Singleton
    fun providesVideoRepository(supabaseClient: SupabaseClient): VideoRepository {
        return VideRepositoryImpl(supabaseClient)
    }

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application) : Context{
        return application.applicationContext
    }
}