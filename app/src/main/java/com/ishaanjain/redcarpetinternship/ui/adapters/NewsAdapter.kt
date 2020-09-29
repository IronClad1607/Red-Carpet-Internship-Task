package com.ishaanjain.redcarpetinternship.ui.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ishaanjain.redcarpetinternship.R
import com.ishaanjain.redcarpetinternship.data.models.Article
import com.ishaanjain.redcarpetinternship.ui.view.NewsDetailActivity
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private val listOfArticles: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article) {
            with(itemView) {
                tvHeadline.text = article.title
                tvDescription.text = article.description

                setOnClickListener {
                    val furtherIntent = Intent(context, NewsDetailActivity::class.java)
                    val bundle = Bundle()

                    bundle.putParcelable("article", article)
                    furtherIntent.putExtra("bundle", bundle)
                    context.startActivity(furtherIntent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(listOfArticles[position])
    }

    override fun getItemCount(): Int = listOfArticles.size
}