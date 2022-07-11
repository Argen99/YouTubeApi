package com.geektech.youtubeapi.remote

import com.geektech.youtubeapi.models.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {

    @GET("playlists")
    fun getPlaylists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResults: String,
        @Query("key") apiKey: String
    ) : Call<Playlist>
}