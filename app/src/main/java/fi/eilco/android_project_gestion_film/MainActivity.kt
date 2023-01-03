package fi.eilco.android_project_gestion_film

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fi.eilco.android_project_gestion_film.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // push our fragment on our fragment_container
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, HomeFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}