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

class SkillActivity : BaseActivity() {
   lateinit var player: Player

    lateinit var beginnerBtn : ToggleButton
    lateinit var ballerBtn : ToggleButton

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)!!
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        beginnerBtn = findViewById(R.id.beginnerBtn)
        ballerBtn = findViewById(R.id.ballerBtn)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
    }

    fun onBeginnerClicked(view: View){
        ballerBtn.isChecked = false

        player.skill = "beginner"
    }

    fun onBallerClicked(view: View){
        beginnerBtn.isChecked = false

        player.skill = "baller"
    }

    fun skillFinishBtn(view: View){
        if(player.skill != ""){
            val finishIntent = Intent(this,FinishActivity :: class.java)
            finishIntent.putExtra(EXTRA_PLAYER,player)
            startActivity(finishIntent)
        } else {
            Toast.makeText(this,"Please select a skill level",Toast.LENGTH_LONG).show()
        }

    }
}