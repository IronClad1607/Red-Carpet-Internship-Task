package com.ishaanjain.redcarpetinternship.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ishaanjain.redcarpetinternship.R
import com.ishaanjain.redcarpetinternship.data.models.Source
import com.ishaanjain.redcarpetinternship.ui.adapters.SourceAdapter
import com.ishaanjain.redcarpetinternship.ui.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_source.*

class SourceActivity : AppCompatActivity() {

    private val vm by lazy {
        ViewModelProvider(this).get(NewsViewModel::class.java)
    }

    private val listOfSources = arrayListOf<Source>()
    private val mAdapter = SourceAdapter(listOfSources)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)

        rvSources.apply {
            layoutManager = LinearLayoutManager(this@SourceActivity, RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }

        vm.fetchSources()
        vm.sources.observe(this, {
            if (!it.isNullOrEmpty()) {
                listOfSources.clear()
                listOfSources.addAll(it)
                mAdapter.notifyDataSetChanged()
            }
        })
    }
}