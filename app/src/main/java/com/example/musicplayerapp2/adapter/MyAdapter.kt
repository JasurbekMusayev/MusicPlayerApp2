package com.example.musicplayerapp2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayerapp2.R
import com.example.musicplayerapp2.databinding.ItemMusicPlayerBinding
import com.example.musicplayerapp2.model.Song

class MyAdapter(val musicClicked: (model: Song) -> Unit) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val list: ArrayList<Song> = ArrayList<Song>()


    private var onLongClick: OnLongClick? = null
    private var onSongClicked: SongClicked? = null
    private var songsSelected: SongsSelected? = null
    private var songsList = mutableListOf<Song>()
    private var selectedSongs = mutableListOf<Song>()
    private var selectionModeActive = false

    fun setList(list: List<Song>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(var itemContactBinding: ItemMusicPlayerBinding) :
        RecyclerView.ViewHolder(itemContactBinding.root) {
        fun onBind(model: Song) {
            itemContactBinding.man2.setImageResource(R.drawable.believer)
            itemContactBinding.title.text = model.title
            itemContactBinding.artistName.text = model.artistName

            itemContactBinding.root.setOnClickListener {
                musicClicked.invoke(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemMusicPlayerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface SongsSelected {
        fun onSelectSongs(selectedSongs: MutableList<Song>)
    }

    interface SongClicked {
        fun onSongClicked(song: Song)
    }

    interface OnLongClick {
        fun onSongLongClicked(position: Int)
    }
}