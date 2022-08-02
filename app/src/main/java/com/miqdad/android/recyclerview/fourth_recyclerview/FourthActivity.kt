package com.miqdad.android.recyclerview.fourth_recyclerview

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.miqdad.android.recyclerview.databinding.ActivityFourthBinding
import com.miqdad.android.recyclerview.fourth_recyclerview.network.ApiClient
import com.miqdad.android.recyclerview.fourth_recyclerview.network.ArticlesItem
import com.miqdad.android.recyclerview.fourth_recyclerview.network.TopHeadlineResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class FourthActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFourthBinding
    private val apiService = ApiClient.getApiService()

    val dataNews = MutableLiveData<TopHeadlineResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDetail()
        dataNews.observe(this){
            setupRecyclerView(it.articles as List<ArticlesItem>)
        }


    }

    private fun setupRecyclerView(data: List<ArticlesItem>) {
        binding.rvNews.apply {
            val mAdapter = NewsAdapter()
            layoutManager = LinearLayoutManager(this@FourthActivity)
            adapter = mAdapter
            mAdapter.setData(data)
        }
    }

    private fun getData(
        responseHandler: (TopHeadlineResponse) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        showLoading(true)
       apiService.getTopHeadlineNews()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe({
               responseHandler(it)
               showLoading(false)
           },{
               errorHandler(it)
           })
    }

    fun getDetail(){
        getData({
            dataNews.value = it
        },{

        })
    }

    private fun showLoading(isLoading : Boolean){
        if (isLoading == true){
            binding.progressMain.visibility = View.VISIBLE
        }else{
            binding.progressMain.visibility = View.INVISIBLE
        }
    }


}