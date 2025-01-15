package com.varun.swooshdemo.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.varun.swooshdemo.Model.Player
import com.varun.swooshdemo.R
import com.varun.swooshdemo.Utilities.EXTRA_PLAYER

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    lateinit var mensLeagueBtn: ToggleButton
    lateinit var womensLeagueBtn: ToggleButton
    lateinit var coedLeagueBtn: ToggleButton

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER,player)
    }

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

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
    }

    fun onMensClicked(view: View) {
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "mens"
    }

    fun onWomenClicked(view: View) {
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "womens"
    }

    fun onCoedClicked(view: View) {
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false

        player.league = "co-ed"
    }

    fun nextLeagueClicked(view: View) {
        if(player.league != ""){
            val skillIntent = Intent(this, SkillActivity :: class.java)
            skillIntent.putExtra(EXTRA_PLAYER,player)
            startActivity(skillIntent)
        } else{
            Toast.makeText(this,"Please select a league",Toast.LENGTH_SHORT).show()
        }
    }
}
