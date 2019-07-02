package com.hardeep.androidkotlindeletion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.hardeep.androidkotlindeletion.database.DatabaseQueries

class MainActivity : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var email : EditText
    lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

    }

    fun addUser(v: View)
    {
        val db = DatabaseQueries(this)
        val res = db.addUser(name.text.toString(),email.text.toString(),password.text.toString())
        if (res>0)
        {
            AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Message")
                .setMessage("Register Successfully")
                .setPositiveButton("ok",null)
                .show()
        }
        else
        {
            AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Alert")
                .setMessage("Something is wrong ,\nPlease Try Again")
                .setPositiveButton("ok",null)
                .show()
        }
    }

    fun login(v: View)
    {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
