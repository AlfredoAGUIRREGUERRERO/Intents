package com.tallercmovil.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tallercmovil.intents.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        when{
            intent?.action== Intent.ACTION_VIEW ->{
                if(intent.type=="application/pdf"){
                    var data = intent.data
                    binding.pdfView.fromUri(data).load()
                }
            }
        }

    }
}