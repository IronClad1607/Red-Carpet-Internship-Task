package com.ishaanjain.redcarpetinternship.ui.view.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ishaanjain.redcarpetinternship.R
import com.ishaanjain.redcarpetinternship.data.models.Article
import com.ishaanjain.redcarpetinternship.ui.adapters.NewsAdapter
import com.ishaanjain.redcarpetinternship.ui.viewmodel.TopHeadlineViewModel
import kotlinx.android.synthetic.main.fragment_usa.view.*

class UsaFragment : Fragment() {

    private val vm by lazy {
        ViewModelProvider(this).get(TopHeadlineViewModel::class.java)
    }

    private val listOfArticles = arrayListOf<Article>()
    private val mAdapter = NewsAdapter(listOfArticles)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflateView = inflater.inflate(R.layout.fragment_usa, container, false)
        inflateView.rvUsa.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }
        vm.fetchUsaHeadline()
        vm.usaHeadlines.observe(this, {
            if (!it.isNullOrEmpty()) {
                listOfArticles.clear()
                listOfArticles.addAll(it)
                mAdapter.notifyDataSetChanged()
            }
        })
        return inflateView
    }
}