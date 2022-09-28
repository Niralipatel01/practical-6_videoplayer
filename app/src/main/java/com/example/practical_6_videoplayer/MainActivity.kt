package com.example.practical_6_videoplayer

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import androidx.core.view.WindowCompat
import com.example.practical_6_videoplayer.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        WindowCompat.setDecorFitsSystemWindows(window,false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVideoPlayer()
        binding.btnSwitch.setOnClickListener {
            Intent(this,YoutubeActivity::class.java).also { startActivity(it) }
        }
    }
    private fun initVideoPlayer(){
        val mediaController=MediaController(this)
        val uri:Uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.thestoryoflight)
        binding.myvideoview.setMediaController(mediaController)
        binding.myvideoview.setVideoURI(uri)
        binding.myvideoview.requestFocus()
        binding.myvideoview.start()



    }
}