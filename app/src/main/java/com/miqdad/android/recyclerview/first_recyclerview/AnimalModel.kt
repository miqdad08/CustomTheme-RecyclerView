package com.miqdad.android.recyclerview.first_recyclerview

import android.content.Context
import com.miqdad.android.recyclerview.R

class AnimalModel(val context: Context) {
    fun getAnimalList():Array<String>{
        return context.resources.getStringArray(R.array.animalList)
    }
}