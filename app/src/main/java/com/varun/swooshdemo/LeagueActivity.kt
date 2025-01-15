package com.varun.swooshdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    lateinit var mensLeagueBtn: ToggleButton
    lateinit var womensLeagueBtn: ToggleButton
    lateinit var coedLeagueBtn: ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_league)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mensLeagueBtn = findViewById(R.id.mensLeagueBtn)
        womensLeagueBtn = findViewById(R.id.womensLeagueBtn)
        coedLeagueBtn = findViewById(R.id.coedLeagueBtn)
    }

    fun onMensClicked(view: View) {
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        selectedLeague = "mens"
    }

    fun onWomenClicked(view: View) {
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        selectedLeague = "womens"
    }

    fun onCoedClicked(view: View) {
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false

        selectedLeague = "co-ed"
    }

    fun nextLeagueClicked(view: View) {
        if(selectedLeague != ""){
            val skillIntent = Intent(this, SkillActivity :: class.java)
            skillIntent.putExtra(EXTRA_LEAGUE,selectedLeague)
            startActivity(skillIntent)
        } else{
            Toast.makeText(this,"Please select a league",Toast.LENGTH_SHORT).show()
        }
    }
}
