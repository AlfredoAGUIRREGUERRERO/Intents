package com.tallercmovil.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.tallercmovil.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            btnIntent.setOnClickListener {

                //Abrir un url
                /*var uri = Uri.parse("https://www.tic.unam.mx")
                startActivity(Intent(Intent.ACTION_VIEW, uri))*/

                //Un teléfono
                /*var uri = Uri.parse("tel:5556581111")
                startActivity(Intent(Intent.ACTION_DIAL, uri))*/

                //Una localización en un mapa
                /*var uri = Uri.parse("geo:0,0?q=DGTIC+UNAM")
                startActivity(Intent(Intent.ACTION_VIEW, uri))*/

                //Un correo (clic to mail)
                val intent = Intent(Intent.ACTION_SENDTO)

                var emails = arrayOf("amaury@comunidad.unam.mx")
                intent.setType("*/*")
                intent.setData(Uri.parse("mailto:"))

                intent.putExtra(Intent.EXTRA_EMAIL, emails)
                intent.putExtra(Intent.EXTRA_SUBJECT, "Prueba")
                intent.putExtra(Intent.EXTRA_TEXT, "Mensaje")

                if(intent.resolveActivity(packageManager)!=null){
                    startActivity(intent)
                }else{
                    Toast.makeText(this@MainActivity, "No hay aplicación compatible", Toast.LENGTH_SHORT).show()

                }

            }

        }

    }




}