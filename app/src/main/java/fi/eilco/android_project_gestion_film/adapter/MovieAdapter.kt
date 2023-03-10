package fi.eilco.android_project_gestion_film.adapter

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import fi.eilco.android_project_gestion_film.MainActivity
import fi.eilco.android_project_gestion_film.R

class MovieAdapter(private val context: MainActivity, private val movieList: ArrayList<fi.eilco.android_project_gestion_film.adapter.MovieModel>): RecyclerView.Adapter<MovieAdapter.ViewHolder> (){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val movieImage=view.findViewById<ImageView>(R.id.image_item)
        val movieName=view.findViewById<TextView>(R.id.item_movie_title)
        val movieRate=view.findViewById<TextView>(R.id.item_movie_rate)
        val movieVotes=view.findViewById<TextView>(R.id.item_movie_votes)

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_film,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Récupérer les information d'un film
        val currentMovie=movieList[position]

        //utiliser glide pour récupérer l'image du film à partir de son lien
        Glide.with(context).load(Uri.parse("https://image.tmdb.org/t/p/original/"+currentMovie.poster_path)).into(holder.movieImage)

        holder.movieName.text=currentMovie.original_title
        holder.movieRate.text=holder.movieRate.text.toString()+currentMovie.vote_average
        holder.movieVotes.text=holder.movieVotes.text.toString()+currentMovie.vote_count





    }

    override fun getItemCount(): Int {
        return movieList.size //compte le nombre de film
    }
}