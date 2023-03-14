package com.example.flixter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class flixer_adapter(var movie_items: List<movie> ):RecyclerView.Adapter<flixer_adapter.flixter_viewholder>() {
    inner class flixter_viewholder(movieView: View):RecyclerView.ViewHolder(movieView){
         val tvPoster = movieView.findViewById<ImageView>(R.id.movie_poster)
         val tvTitle = movieView.findViewById<TextView>(R.id.movie_title)
         val tvOverview = movieView.findViewById<TextView>(R.id.movie_overview)


    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): flixter_viewholder {
            val view= LayoutInflater.from(parent.context).inflate(R.layout.item_movies,parent,false)
            return flixter_viewholder(view)
        }

        override fun getItemCount(): Int {
            return movie_items.size
        }

        override fun onBindViewHolder(holder: flixter_viewholder, position: Int) {
                val movieFilm=movie_items[position]

                holder.mitem=movieFilm
                holder.tvTitle.text=movie_items[position].title
                holder.tvOverview.text=movie_items[position].overview
            Glide.with(holder.itemView)
                .load("https://image.tmdb.org/t/p/w500/")
                .into(holder.tvPoster)



        }

    }

