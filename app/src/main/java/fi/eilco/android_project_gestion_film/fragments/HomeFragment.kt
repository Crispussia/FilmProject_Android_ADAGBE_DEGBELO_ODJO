package fi.eilco.android_project_gestion_film.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fi.eilco.android_project_gestion_film.R


class HomeFragment ( ): Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        //recupérer le recycler view
        val recycler = view?.findViewById<RecyclerView>(R.id.recycler)

        return view
    }


}
