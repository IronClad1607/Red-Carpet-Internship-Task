package com.ishaanjain.redcarpetinternship.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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