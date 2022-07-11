package com.geektech.youtubeapi.ui.play_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.youtubeapi.BuildConfig.API_KEY
import com.geektech.youtubeapi.core.Constant
import com.geektech.youtubeapi.models.Playlist
import com.geektech.youtubeapi.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistsViewModel: ViewModel() {

    private val youTubeApi = RetrofitClient.provideRetrofit()

    fun getPlayLists(): LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()

        youTubeApi.getPlaylists(Constant.PART
            ,Constant.CHANNEL_ID
            ,Constant.MAX_RESULT
            ,API_KEY)
            .enqueue(object: Callback<Playlist>{
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if(response.isSuccessful && response.body() != null){
                        data.value = response.body()
                    }
                }
                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    Log.e("ololo","onFailure: ${t.localizedMessage}")
                }
            })
        return data
    }
}