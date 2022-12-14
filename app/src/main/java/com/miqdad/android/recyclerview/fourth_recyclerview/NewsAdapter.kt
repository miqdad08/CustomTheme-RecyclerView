package com.miqdad.android.recyclerview.fourth_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.miqdad.android.recyclerview.databinding.ActivityFourthBinding
import com.miqdad.android.recyclerview.databinding.ActivityThirdBinding
import com.miqdad.android.recyclerview.databinding.ItemNewsBinding
import com.miqdad.android.recyclerview.fourth_recyclerview.network.ArticlesItem

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    private var listNews = ArrayList<ArticlesItem>()

    fun setData(data: List<ArticlesItem>) {
        if (data == null) return
        listNews.clear()
        listNews.addAll(data)
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class MyViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= MyViewHolder(
        ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listNews[position]
        holder.binding.apply {
            tvTitle.text =data.title
            Glide.with(imageMovie)
                .load(data.urlToImage)
                .apply(RequestOptions())
                .override(500, 500)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(imageMovie)
        }
    }

    override fun getItemCount()= listNews.size


}