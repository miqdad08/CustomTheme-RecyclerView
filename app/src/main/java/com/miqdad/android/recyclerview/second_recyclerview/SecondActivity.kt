package com.miqdad.android.recyclerview.second_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.miqdad.android.recyclerview.R
import com.miqdad.android.recyclerview.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHewan.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SecondRVAdapter(SecondRVData.listData)
        }
    }
}