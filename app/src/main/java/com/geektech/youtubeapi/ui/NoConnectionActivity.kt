package com.geektech.youtubeapi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.youtubeapi.core.BaseActivity.Companion.isOnline
import com.geektech.youtubeapi.databinding.ActivityNoConnectionBinding
import com.geektech.youtubeapi.extensions.showToast
import com.geektech.youtubeapi.ui.play_list.PlaylistActivity

class NoConnectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoConnectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoConnectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTryAgain.setOnClickListener {
            Intent(this, PlaylistActivity::class.java).apply {
                if (isOnline(this@NoConnectionActivity)) {
                    startActivity(this)
                    finish()
                }else{
                    showToast("No Internet Connection")
                }
            }
        }
    }
}