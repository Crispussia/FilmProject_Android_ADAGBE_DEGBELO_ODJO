package fi.eilco.android_project_gestion_film

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fi.eilco.android_project_gestion_film.UserRepository.Singleton.databaseRef
import fi.eilco.android_project_gestion_film.UserRepository.Singleton.user


class UserRepository(private var context:Activity ) {
    //accéder à ces deux valeurs sur toutes l'application sans vider à chaque chargement
    object Singleton {
            //se connecter à la référence plante
            val databaseRef = FirebaseDatabase.getInstance().getReference("users")

            //creer une liste qui va contenir nos users
            val user = UserModel()
    }
    fun createUsers( usernameText : String,passwordText:String){
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
                    //Toast.makeText(context,"User registered successfully", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
    fun loginUser( usernameText : String,passwordText:String){
        user.username=usernameText
        user.password=passwordText

        Log.d("Log","dfgh")
        //absorber les données depuis la databaseRef->liste des plantes
        databaseRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                //create user in database

                if(snapshot.hasChild(usernameText)){
                    Log.d("Sucess", snapshot.child(usernameText).toString())
                    //now get password of user from firebase data and match it with user entered
                    val getPassword = snapshot.child(usernameText).child("password").getValue().toString()
                    if (getPassword.equals(passwordText)) {
                        Toast.makeText(
                            context,
                            "Successfull Logged in",
                            Toast.LENGTH_SHORT
                        ).show()
                        
                        /*val intentMain = Intent(context, MainActivity::class.java)
                        intentMain.apply {

                            startActivity(this)
                        }*/
                    } else {
                        Toast.makeText(context, "Wrong Password", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                else{
                    Toast.makeText(context, "Wrong username", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
    //mettre à jour un objet plante en bdd
    fun getLiked(user:UserModel,usernameText: String) {

        Log.d("Log","dfgh")
        //absorber les données depuis la databaseRef->liste des plantes
        databaseRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                var liked = snapshot.child(usernameText).child("liked").getValue().toString()
                //Log.d("Log",liked)

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }
    //mettre à jour un objet plante en bdd
    fun testLiked(usernameText: String): Task<DataSnapshot> {

        Log.d("Log","dfgh")
        var liked = databaseRef.child(usernameText).child("liked").get()
        return liked


    }

    //mettre à jour un objet plante en bdd
    fun updateUser(user:UserModel,usernameText: String){
        databaseRef.child(usernameText).setValue(user)
    }

}