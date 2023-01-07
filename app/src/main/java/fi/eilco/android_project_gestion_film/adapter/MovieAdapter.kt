package fi.eilco.android_project_gestion_film.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import fi.eilco.android_project_gestion_film.R

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    // boite pour ranger les composants à controler
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        // image movie
        val movieImage = view.findViewById<ImageView>(R.id.image_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_film, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }
}