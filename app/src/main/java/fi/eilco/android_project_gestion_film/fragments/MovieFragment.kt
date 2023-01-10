package fi.eilco.android_project_gestion_film.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fi.eilco.android_project_gestion_film.MainActivity
import fi.eilco.android_project_gestion_film.MovieModel
import fi.eilco.android_project_gestion_film.R
import fi.eilco.android_project_gestion_film.adapter.MovieAdapter

class MovieFragment (private val  context: MainActivity): Fragment() {
    //permet d'injecter mon layout fragment home
    override fun onCreateView(
        inflater: LayoutInflater,

        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //injecter sur home fragment le fragment injecter
        val view = inflater?.inflate(R.layout.fragment_film, container, false)

        //creer une liste qui va stocker ces plantes
        val movieList = ArrayList<MovieModel>()
        //enregistrer une première plante dans notre liste
        movieList.add(
            MovieModel(
            "Avatar: The Way of Water",
                "Set more than a decade after the events of the first film, learn the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.",
                "/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg",
                "2022-12-14",
                "7.716",
                "3876",
                "https://image.tmdb.org/t/p/original/"+ "t6HIqrRAclMCA60NsSmeqe9RmNV.jpg",
                "Rate : 3",
                "Votes : 3",
                76600,


        ))
        movieList.add(
            MovieModel(
                "Avatar",
                "In the 22nd century, a paraplegic Marine is dispatched to the moon Pandora on a unique mission, but becomes torn between following orders and protecting an alien civilization.",
                "/jRXYjXNq0Cs2TcJjLkki24MLp7u.jpg",
                "2009-12-15",
                "7.716",
                "3876",
                "https://image.tmdb.org/t/p/original/"+ "jRXYjXNq0Cs2TcJjLkki24MLp7u.jpg",
                "Rate : 3",
                "Votes : 3",
                19995


            ))


        //recuperer le recyclerview


        val verticalRecyclerView = view?.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        //verticalRecyclerView?.adapter = MovieAdapter(context, movieList)

        return view
    }
}