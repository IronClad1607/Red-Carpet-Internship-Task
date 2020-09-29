package com.ishaanjain.redcarpetinternship.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ishaanjain.redcarpetinternship.R
import com.ishaanjain.redcarpetinternship.ui.view.home.SearchActivity
import com.ishaanjain.redcarpetinternship.ui.view.home.SourceActivity
import com.ishaanjain.redcarpetinternship.ui.view.home.TopHeadlineActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        cvTopHeadlines.setOnClickListener {
            val topIntent = Intent(this, TopHeadlineActivity::class.java)
            startActivity(topIntent)
        }

        cvSearch.setOnClickListener {
            val searchIntent = Intent(this, SearchActivity::class.java)
            startActivity(searchIntent)
        }

        cvSources.setOnClickListener {
            val sourceIntent = Intent(this, SourceActivity::class.java)
            startActivity(sourceIntent)
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}