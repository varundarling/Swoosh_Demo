package com.varun.swooshdemo.Controller

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.varun.swooshdemo.R
import com.varun.swooshdemo.Utilities.EXTRA_LEAGUE
import com.varun.swooshdemo.Utilities.EXTRA_SKILL

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_finish)

        val league = intent.getStringExtra(EXTRA_LEAGUE)
        val skill = intent.getStringExtra(EXTRA_SKILL)

        var searchLeague : TextView = findViewById(R.id.searchLeagueText)

        searchLeague.text = "Looking for $league $skill league near you..."
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}