package com.haumealabs.ratingsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.haumealabs.rating.RatingManager

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ratingManager = RatingManager(this, lifecycleScope)
        enableEdgeToEdge()
        setContent { App(ratingManager) }
    }
}