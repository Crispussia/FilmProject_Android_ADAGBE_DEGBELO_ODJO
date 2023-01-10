package fi.eilco.android_project_gestion_film.adapter

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fi.eilco.android_project_gestion_film.*

class MovieAdapter(private val context: MainActivity, private val movieList:List<MovieModel>): RecyclerView.Adapter<MovieAdapter.ViewHolder> (){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val movieImage=view.findViewById<ImageView>(R.id.image_item)
        val movieName=view.findViewById<TextView>(R.id.item_movie_title)
        val movieRate=view.findViewById<TextView>(R.id.item_movie_rate)
        val movieVotes=view.findViewById<TextView>(R.id.item_movie_votes)
        val likeIcon=view.findViewById<ImageView>(R.id.ic_heart_empty)
        var liked: MutableList<Int>  = mutableListOf()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //elle s'actionne pour chacune de nos plantes et vas passer la position de la plante
        val currentMovie =movieList[position]
        //recuperer l'image à partir de son lien
        //creer une liste qui va contenir nos users
        val user = UserModel()
        Glide.with(context).load(Uri.parse(currentMovie.imageLink)).into(holder.movieImage)
        holder.movieName.text=currentMovie.original_title
        holder.movieRate.text=holder.movieRate.text.toString()+currentMovie.vote_average
        holder.movieVotes.text=holder.movieVotes.text.toString()+currentMovie.vote_count
        //recuperer le repo
        val repo= UserRepository(context)

        val user_object=repo.testLiked("Crispussia")
        //Log.d("Crisp_obj",user_object)


        //var liked=repo.getLiked(user,"Crispussia")
        //Log.d("Crisp",liked.toString())
        if (holder.liked.isNullOrEmpty()) {
            holder.likeIcon.setImageResource(R.drawable.ic_unlike)
        }else{
            if (holder.liked.contains(currentMovie.id)) {
                holder.likeIcon.setImageResource(R.drawable.ic_like)
            }else{
                holder.likeIcon.setImageResource(R.drawable.ic_unlike)
            }
        }

        //rajouter une interaction sur cette étoile
        holder.likeIcon.setOnClickListener{
            //inverse si le bouton est like ou non
            //currentPlant.liked=!currentPlant.liked
            //mettre à jour l'objetplante
            //repo.updatePlant(currentPlant)
            Log.d("debut",holder.liked.toString())
            if (holder.liked.isNullOrEmpty()) {
                holder.likeIcon.setImageResource(R.drawable.ic_like)
                holder.liked.add(currentMovie.id)

                Log.d("Crisp",holder.liked.toString())
                user.liked=holder.liked
                Log.d("Crisp",user.liked.toString())
                repo.updateUser(user,"Hermione")
            }else{
                if (holder.liked.contains(currentMovie.id)) {
                    holder.likeIcon.setImageResource(R.drawable.ic_unlike)
                    holder.liked.remove(currentMovie.id)
                    Log.d("Crisp",holder.liked.toString())
                    user.liked=holder.liked
                    repo.updateUser(user,"Hermione")
                }else{
                    holder.likeIcon.setImageResource(R.drawable.ic_like)
                    holder.liked.add(currentMovie.id)
                    Log.d("Crisp",holder.liked.toString())
                    user.liked=holder.liked
                    repo.updateUser(user,"Hermione")
                }
            }
        }
    }

    override fun getItemCount(): Int =movieList.size
}