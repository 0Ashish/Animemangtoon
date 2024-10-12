package com.example.animemangtoon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animemangtoon.R
import com.example.animemangtoon.model.Webtoon


class WebtoonAdapter(
    private val webtoons: List<Webtoon>,
    private val onClick: (Webtoon) -> Unit
) : RecyclerView.Adapter<WebtoonAdapter.WebtoonViewHolder>() {


    inner class WebtoonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.webtoonTitle)
        val image: ImageView = itemView.findViewById(R.id.webtoonImage)
        val descriptionTextView = itemView.findViewById<TextView>(R.id.webtoonDescription)

        fun bind(webtoon: Webtoon) {
            title.text = webtoon.title
            descriptionTextView.text = webtoon.description
//            loading image
            Glide.with(itemView.context).load(webtoon.imageUrl).into(image)

            itemView.setOnClickListener { onClick(webtoon) }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebtoonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_webtoon, parent, false)
        return WebtoonViewHolder(view)
    }

    override fun onBindViewHolder(holder: WebtoonViewHolder, position: Int) {
        holder.bind(webtoons[position])
    }

    override fun getItemCount() = webtoons.size

    fun getItemAtPosition(position: Int): Webtoon {
        return webtoons[position]
    }
}
