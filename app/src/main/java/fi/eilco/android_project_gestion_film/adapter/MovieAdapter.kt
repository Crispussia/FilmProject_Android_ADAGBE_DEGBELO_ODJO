package fi.eilco.android_project_gestion_film.adapter

<<<<<<< HEAD
import android.annotation.SuppressLint
import android.net.Uri
=======
import android.net.Uri
import android.util.Log
>>>>>>> 29be78f45be8614a8edc677d84713f6b85b69bb0
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
<<<<<<< HEAD
import fi.eilco.android_project_gestion_film.MainActivity
import fi.eilco.android_project_gestion_film.R
import fi.eilco.android_project_gestion_film.fragments.GenreFragment
=======
import fi.eilco.android_project_gestion_film.*
>>>>>>> 29be78f45be8614a8edc677d84713f6b85b69bb0

class MovieAdapter(private val context: MainActivity, private val movieList:List<MovieModel>): RecyclerView.Adapter<MovieAdapter.ViewHolder> (){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val movieImage=view.findViewById<ImageView>(R.id.image_item)
        val movieName=view.findViewById<TextView>(R.id.item_movie_title)
        val movieRate=view.findViewById<TextView>(R.id.item_movie_rate)
        val movieVotes=view.findViewById<TextView>(R.id.item_movie_votes)
<<<<<<< HEAD


    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie,parent,false)
=======
        val likeIcon=view.findViewById<ImageView>(R.id.ic_heart_empty)
        var liked: MutableList<Int>  = mutableListOf()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
>>>>>>> 29be78f45be8614a8edc677d84713f6b85b69bb0
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
<<<<<<< HEAD
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
=======
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
>>>>>>> 29be78f45be8614a8edc677d84713f6b85b69bb0
}