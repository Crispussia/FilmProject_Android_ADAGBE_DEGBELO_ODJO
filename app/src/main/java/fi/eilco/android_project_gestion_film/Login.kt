package fi.eilco.android_project_gestion_film

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.motion.widget.Debug.getName
import java.security.AccessController.getContext

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginButton=findViewById<Button>(R.id.loginBtn)
        val registerButton=findViewById<TextView>(R.id.registerNowBtn)
        val username=findViewById<TextView>(R.id.username_input)
        val password=findViewById<TextView>(R.id.password_input)
        loginButton.setOnClickListener {
            val usernameText = username.text.toString()
            val passwordText = password.text.toString()

            /*if(getLocalClassName().equals("Login")){
                Toast.makeText(
                    this@Login,
                    getLocalClassName().toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }*/
            if (usernameText.isEmpty()||passwordText.isEmpty()){
                Toast.makeText(this,"Please enter your username or password",Toast.LENGTH_SHORT).show()
            }else {
                Log.d("Log", usernameText)
                var repository = UserRepository(this)
                repository.loginUser(usernameText,passwordText)
            }
        }
        registerButton.setOnClickListener{
            val intentRegister = Intent(this, Register::class.java)
            intentRegister.apply {

                startActivity(this)
            }


        }
    }
}