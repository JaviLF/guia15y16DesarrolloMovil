package edu.bo.ucb.testconectionapplication

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val my_image_view = findViewById(R.id.my_image_view) as ImageView
        val picasso = Picasso.get()
        picasso.load(
            "https://i.pinimg.com/564x/a8/6e/26/a86e26dffbcd0f8ffd0b7a6a4809ec68.jpg")
            .into(my_image_view)

        val button3 = findViewById(R.id.btnSC) as Button

        button3.setOnClickListener {
            if(isConexion(applicationContext)) {
                Toast.makeText(this, "Tiene acceso a internet", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No tiene acceso a internet", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun isConexion( context: Context) : Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}