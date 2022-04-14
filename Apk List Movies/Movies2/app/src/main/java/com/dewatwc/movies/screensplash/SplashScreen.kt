package com.dewatwc.movies.screensplash


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View.*
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dewatwc.movies.R
import com.dewatwc.movies.ui.home.MoviesActivity

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_splash)

        Handler().postDelayed({
            startActivity(Intent(this, MoviesActivity::class.java))
            finish()
        }, 2500)

        val img: ImageView = findViewById(R.id.logoMovie)
        Glide.with(this)
                .load(R.drawable.logo)
                .apply(RequestOptions().override(500, 500))
                .into(img)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean){
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (SYSTEM_UI_FLAG_IMMERSIVE
                or SYSTEM_UI_FLAG_LAYOUT_STABLE
                or SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or SYSTEM_UI_FLAG_FULLSCREEN)
    }
}