package com.balditsyn.stackoveflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.balditsyn.stackoveflow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        showLoadingState(true)
    }

    fun showLoadingState (isLoading: Boolean) {
        binding.swipe.isRefreshing = isLoading
    }

    fun setOnRefreshListener(listener: SwipeRefreshLayout.OnRefreshListener) {
        binding.swipe.setOnRefreshListener(listener)
    }
}

