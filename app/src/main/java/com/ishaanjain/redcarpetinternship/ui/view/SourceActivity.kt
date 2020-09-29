package com.ishaanjain.redcarpetinternship.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ishaanjain.redcarpetinternship.R
import com.ishaanjain.redcarpetinternship.data.models.SourcesResponse
import com.ishaanjain.redcarpetinternship.ui.viewmodel.NewsViewModel

class SourceActivity : AppCompatActivity() {

    private val vm by lazy {
        ViewModelProvider(this).get(NewsViewModel::class.java)
    }

    private var sources: SourcesResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)

        vm.fetchSources()
        vm.sources.observe(this, {
            Log.d("PUI", "$it")
        })
    }
}