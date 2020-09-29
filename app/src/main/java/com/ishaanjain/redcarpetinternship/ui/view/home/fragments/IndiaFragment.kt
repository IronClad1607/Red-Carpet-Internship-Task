package com.ishaanjain.redcarpetinternship.ui.view.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ishaanjain.redcarpetinternship.R
import com.ishaanjain.redcarpetinternship.data.models.Article
import com.ishaanjain.redcarpetinternship.ui.adapters.NewsAdapter
import com.ishaanjain.redcarpetinternship.ui.viewmodel.TopHeadlineViewModel
import kotlinx.android.synthetic.main.fragment_india.view.*

class IndiaFragment : Fragment() {

    private val vm by lazy {
        ViewModelProvider(this).get(TopHeadlineViewModel::class.java)
    }

    private val listOfArticles = arrayListOf<Article>()
    private val mAdapter = NewsAdapter(listOfArticles)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflatedView = inflater.inflate(R.layout.fragment_india, container, false)
        inflatedView.rvIndia.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }
        vm.fetchIndiaHeadline()
        vm.indiaHeadlines.observe(this, {
            if (!it.isNullOrEmpty()) {
                listOfArticles.clear()
                listOfArticles.addAll(it)
                mAdapter.notifyDataSetChanged()
            }
        })
        return inflatedView
    }
}