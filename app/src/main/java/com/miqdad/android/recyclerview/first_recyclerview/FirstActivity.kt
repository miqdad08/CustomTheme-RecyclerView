package com.miqdad.android.recyclerview.first_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.miqdad.android.recyclerview.R
import com.miqdad.android.recyclerview.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animalList = AnimalModel(this).getAnimalList()
        binding.rvAnimal.adapter = AnimalAdapter(animalList)
    }
}