package fi.eilco.android_project_gestion_film

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import fi.eilco.android_project_gestion_film.fragments.GenreFragment
=======
import fi.eilco.android_project_gestion_film.fragments.MovieFragment
>>>>>>> 29be78f45be8614a8edc677d84713f6b85b69bb0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< HEAD

        //injecter le fragment dans la boite (fragment_container)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, GenreFragment(this))
        transaction.addToBackStack(null)
=======
        //charger notre plant repository

        //injecter le fragment dans notre boite(fragment_container)
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,MovieFragment(this))
        transaction.addToBackStack(null)//permet de ne pas avoir de retour sur ce composant
>>>>>>> 29be78f45be8614a8edc677d84713f6b85b69bb0
        transaction.commit()
    }
}