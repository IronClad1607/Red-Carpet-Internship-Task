package com.ishaanjain.redcarpetinternship.ui.view.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ishaanjain.redcarpetinternship.R
import com.ishaanjain.redcarpetinternship.data.models.Article
import com.ishaanjain.redcarpetinternship.ui.adapters.NewsAdapter
import com.ishaanjain.redcarpetinternship.ui.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    private val vm by lazy {
        ViewModelProvider(this).get(SearchViewModel::class.java)
    }

    private val listOfArticles = arrayListOf<Article>()
    private val mAdapter = NewsAdapter(listOfArticles)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        rvSearch.apply {
            layoutManager = LinearLayoutManager(this@SearchActivity, RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }

        searchView.isSubmitButtonEnabled = true
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    findNews(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    findNews(newText)
                }
                return true
            }
        })

        searchView.setOnCloseListener {
            listOfArticles.clear()
            mAdapter.notifyDataSetChanged()
            return@setOnCloseListener true
        }
    }

    private fun findNews(keyword: String) {
        vm.searchNews(keyword).observe(this, {
            val list = it.articles
            Log.d("PUI", "$list")
            if (!list.isNullOrEmpty()) {
                listOfArticles.clear()
                listOfArticles.addAll(list)
                mAdapter.notifyDataSetChanged()
            }
        })
    }
}

