package com.miqdad.android.recyclerview.second_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miqdad.android.recyclerview.databinding.SecondItemBinding

class SecondRVAdapter(private val listSecondItem : ArrayList<RVData>): RecyclerView.Adapter<SecondRVAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: SecondItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        SecondItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            with(listSecondItem[position]){
                tvTitle.text = textData
                Glide.with(imgHewan.context).load(imgData).into(imgHewan)
            }
        }
    }

    override fun getItemCount(): Int = listSecondItem.size
}