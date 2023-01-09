package fi.eilco.android_project_gestion_film

import android.app.Activity
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fi.eilco.android_project_gestion_film.UserRepository.Singleton.databaseRef
import fi.eilco.android_project_gestion_film.UserRepository.Singleton.user


class UserRepository(private  var context:Activity, ) {
    //accéder à ces deux valeurs sur toutes l'application sans vider à chaque chargement
    object Singleton {
            //se connecter à la référence plante
            val databaseRef = FirebaseDatabase.getInstance().getReference("users")

            //creer une liste qui va contenir nos users
            val user = UserModel()
    }
    fun getUsers( usernameText : String,passwordText:String){
        user.username=usernameText
        user.password=passwordText

        Log.d("Log","dfgh")
        //absorber les données depuis la databaseRef->liste des plantes
        databaseRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                //create user in database
                if(snapshot.hasChild(usernameText)){
                    Toast.makeText(context,"User registered error", Toast.LENGTH_SHORT).show()
                }else {
                    databaseRef.child(usernameText).child("username").setValue(user.username)
                    databaseRef.child(usernameText).child("password").setValue(user.password)
                    databaseRef.child(usernameText).child("liked").setValue(user.liked)
                    Toast.makeText(context,"User registered successfully", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}