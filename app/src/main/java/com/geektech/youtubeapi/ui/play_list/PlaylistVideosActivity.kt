package com.geektech.youtubeapi.ui.play_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.youtubeapi.R
import com.geektech.youtubeapi.extensions.showToast

class PlaylistVideosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist_videos)

        val id = intent.getStringExtra(PlaylistActivity.pActPvActKey)
        id?.let { showToast(it) }
    }
}