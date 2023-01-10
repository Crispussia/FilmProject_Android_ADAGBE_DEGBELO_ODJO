package fi.eilco.android_project_gestion_film

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val username=findViewById<TextView>(R.id.username_input)
        val password=findViewById<TextView>(R.id.password_input)
        val conpassword=findViewById<TextView>(R.id.confirm_password_input)
        //charger notre plant repository
        val registerButton=findViewById<TextView>(R.id.registerBtn)
        val LoginNowButton=findViewById<TextView>(R.id.loginNow)


        registerButton.setOnClickListener{
            var repository = UserRepository(this)
            //get data from edittexts
            val usernameText=username.text.toString()

            val passwordText=password.text.toString()
            val conPasswordText=conpassword.text.toString()
            //verifier que tous les champs sont remplis
            //verifier que tous les champs sont remplis
            if(usernameText.isEmpty()||passwordText.isEmpty()||conPasswordText.isEmpty()){
                Toast.makeText(this,"Please fill all fields", Toast.LENGTH_SHORT).show()
            }
            //check if passwords are matching with each other
            else if(!passwordText.equals(conPasswordText)){
                Toast.makeText(this,"Password are not matching", Toast.LENGTH_SHORT).show()
            }else {
                //sending data to firebase
                //we use username as unique identity of every user
                repository.createUsers(usernameText,passwordText)

            }

        }
        LoginNowButton.setOnClickListener{
            val intentLogin = Intent(this, Login::class.java)
            intentLogin.apply {
                startActivity(this)
            }
        }


    }


}