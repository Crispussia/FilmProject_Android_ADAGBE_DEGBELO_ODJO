package fi.eilco.android_project_gestion_film

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fi.eilco.android_project_gestion_film.fragments.MovieFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //charger notre plant repository

        //injecter le fragment dans notre boite(fragment_container)
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,MovieFragment(this))
        transaction.addToBackStack(null)//permet de ne pas avoir de retour sur ce composant
        transaction.commit()
    }
}