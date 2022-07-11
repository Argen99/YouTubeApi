package com.geektech.youtubeapi.ui.play_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.youtubeapi.R
import com.geektech.youtubeapi.databinding.ItemPlaylistsBinding
import com.geektech.youtubeapi.extensions.loadImage
import com.geektech.youtubeapi.models.Items

class PlaylistAdapter(private var playlists: ArrayList<Items>): RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    private lateinit var clickListener: ItemClickListener

    fun setItemClickListener(clickListener: ItemClickListener){
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(ItemPlaylistsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.onBind(playlists[position])
    }

    override fun getItemCount() = playlists.size

    inner class PlaylistViewHolder(private val binding: ItemPlaylistsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(items: Items) {
            binding.ivVideoImage.loadImage(items.snippet.thumbnails.medium.url)
            binding.tvTitle.text = items.snippet.title
            binding.tvVideoCount.text = itemView.context.getString(
                R.string.video_series, items.contentDetails.itemCount)

            itemView.setOnClickListener {
                clickListener.onItemClick(items.id)
            }
        }
    }
}
interface ItemClickListener {

    fun onItemClick(id: String)
}