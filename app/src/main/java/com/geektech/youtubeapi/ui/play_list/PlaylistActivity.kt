package com.geektech.youtubeapi.ui.play_list

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.geektech.youtubeapi.core.BaseActivity
import com.geektech.youtubeapi.databinding.ActivityPlaylistBinding
import com.geektech.youtubeapi.extensions.showToast
import com.geektech.youtubeapi.models.Items
import com.geektech.youtubeapi.ui.NoConnectionActivity

class PlaylistActivity : BaseActivity<ActivityPlaylistBinding>(), ItemClickListener {

    private lateinit var viewModel: PlaylistsViewModel
    private var playlists = arrayListOf<Items>()
    private val adapter by lazy { PlaylistAdapter(playlists) }

    override fun inflateViewBinding(): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {
        if(isOnline(this)){
           showToast("internet connected")
        }else{
            Intent(this,NoConnectionActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }

    override fun initClickLIsteners() {
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this)[PlaylistsViewModel::class.java]

        viewModel.getPlayLists().observe(this) { data->
            playlists = data.items
            adapter.setItemClickListener(this)
            binding.rvPlaylist.adapter = adapter
        }
    }

    override fun setUi() {
    }

    override fun onItemClick(id: String) {
        Intent(this, PlaylistVideosActivity::class.java).apply {
            putExtra(pActPvActKey,id)
            startActivity(this)
        }
    }

    companion object {
        val pActPvActKey = "key"
    }
}