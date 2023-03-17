package com.example.flixter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class flixer_adapter(private val movie_items: List<movie>, private val mListner: OnListFragmentInteractionListener? )
    :RecyclerView.Adapter<flixer_adapter.flixter_viewholder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): flixter_viewholder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_movies,parent,false)
        return flixter_viewholder(view)
    }
    inner class flixter_viewholder(val movieView: View):RecyclerView.ViewHolder(movieView) {
        var mItem: movie? = null
        val tvTitle = movieView.findViewById<View>(R.id.movie_title) as TextView
        val tvOverview = movieView.findViewById<View>(R.id.movie_overview) as TextView
        val tvPoster = movieView.findViewById<View>(R.id.movie_poster) as ImageView

        override fun toString(): String {
            return tvTitle.toString()
        }
    }

        override fun onBindViewHolder(holder: flixter_viewholder, position: Int) {
                val movieFilm=movie_items[position]

                holder.mItem=movieFilm
                holder.tvTitle.text=movieFilm.title
                holder.tvOverview.text=movieFilm.overview

            Glide.with(holder.movieView)
                .load("https://image.tmdb.org/t/p/w500/${movieFilm.movieImageUrl}")
                .centerInside()
                .into(holder.tvPoster)

            holder.movieView.setOnClickListener {
                holder.mItem?.let { book ->
                    mListner?.onItemClick(book)
                }
        }
    }
    override fun getItemCount(): Int {
        return movie_items.size
    }
    }



