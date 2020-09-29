package com.ishaanjain.redcarpetinternship.ui.view

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import com.bumptech.glide.Glide
import com.ishaanjain.redcarpetinternship.R
import com.ishaanjain.redcarpetinternship.data.models.Article
import kotlinx.android.synthetic.main.activity_news_detail.*
import kotlinx.android.synthetic.main.activity_top_headline.view.*

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val bundle = intent.getBundleExtra("bundle")!!
        val article = bundle.getParcelable<Article>("article")!!
        Glide.with(this).load(article.urlToImage).into(ivBanner)
        tvHeadline.text = article.title
        if (article.content.isNullOrEmpty()) {
            tvDescription.text = article.description
        } else {
            tvDescription.text = article.content
        }

        val source: String
        source = when {
            article.author.isNullOrEmpty() -> {
                article.source!!.name!!
            }
            article.author.contains(",") -> {
                article.author
            }
            article.author.contains("www.") -> {
                article.source!!.name!!
            }
            else -> {
                "${article.author}, ${article.source!!.name!!}"
            }
        }

        tvBy.text = source

        tvURL.text = article.url
        tvURL.setOnClickListener {
            val dataIntent = Intent()
            dataIntent.action = Intent.ACTION_VIEW
            dataIntent.data = Uri.parse(article.url)
            try {
                startActivity(dataIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Site Invalid", Toast.LENGTH_SHORT).show()
            }
        }

    }
}