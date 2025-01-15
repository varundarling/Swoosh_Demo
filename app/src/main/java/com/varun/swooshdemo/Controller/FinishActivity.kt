package com.varun.swooshdemo.Controller

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.varun.swooshdemo.Model.Player
import com.varun.swooshdemo.R
import com.varun.swooshdemo.Utilities.EXTRA_PLAYER

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        var searchLeague : TextView = findViewById(R.id.searchLeagueText)

        searchLeague.text = "Looking for ${player!!.league} ${player!!.skill} league near you..."
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}