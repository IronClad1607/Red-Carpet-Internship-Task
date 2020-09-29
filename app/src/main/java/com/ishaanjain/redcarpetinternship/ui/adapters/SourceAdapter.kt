package com.ishaanjain.redcarpetinternship.ui.adapters

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ishaanjain.redcarpetinternship.R
import com.ishaanjain.redcarpetinternship.data.models.Source
import kotlinx.android.synthetic.main.item_sources.view.*

class SourceAdapter(private val listOfSources: List<Source>) :
    RecyclerView.Adapter<SourceAdapter.SourceViewHolder>() {

    class SourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(source: Source) {
            with(itemView) {
                tvName.text = source.name
                tvDescription.text = source.description

                setOnClickListener {
                    val siteIntent = Intent()
                    siteIntent.action = Intent.ACTION_VIEW
                    siteIntent.data = Uri.parse(source.url)

                    try {
                        context.startActivity(siteIntent)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(context, "Site Invalid", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceViewHolder {
        return SourceViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_sources, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        holder.bind(listOfSources[position])
    }

    override fun getItemCount(): Int = listOfSources.size
}