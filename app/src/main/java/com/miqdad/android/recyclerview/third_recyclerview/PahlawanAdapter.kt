package com.miqdad.android.recyclerview.third_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miqdad.android.recyclerview.databinding.ItemPahlawanBinding

class PahlawanAdapter(val listPahlawan : MutableList<ModelPahlawan>): RecyclerView.Adapter<PahlawanAdapter.MyViewHolder>() {


    class MyViewHolder(val itemPahlawan : ItemPahlawanBinding): RecyclerView.ViewHolder(itemPahlawan.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemPahlawan.apply {
            with(listPahlawan[position]){
                tvNamaPahlawan.text = nama
                tvNamaLengkap.text = nama
                Glide.with(imagePahlawan.context).load(image).into(imagePahlawan)
            }
        }
    }

    override fun getItemCount(): Int {
        return listPahlawan.size
    }
}