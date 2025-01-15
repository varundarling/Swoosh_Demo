package com.varun.swooshdemo.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.varun.swooshdemo.Utilities.EXTRA_LEAGUE
import com.varun.swooshdemo.R
import com.varun.swooshdemo.Utilities.EXTRA_SKILL

class SkillActivity : BaseActivity() {
    var league = ""
    var skill = ""

    lateinit var beginnerBtn : ToggleButton
    lateinit var ballerBtn : ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE).toString()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        beginnerBtn = findViewById(R.id.beginnerBtn)
        ballerBtn = findViewById(R.id.ballerBtn)
    }

    fun onBeginnerClicked(view: View){
        ballerBtn.isChecked = false

        skill = "beginner"
    }

    fun onBallerClicked(view: View){
        beginnerBtn.isChecked = false

        skill = "baller"
    }

    fun skillFinishBtn(view: View){
        if(skill != ""){
            val finishIntent = Intent(this,FinishActivity :: class.java)
            finishIntent.putExtra(EXTRA_LEAGUE,league)
            finishIntent.putExtra(EXTRA_SKILL,skill)
            startActivity(finishIntent)
        } else {
            Toast.makeText(this,"Please select a skill level",Toast.LENGTH_LONG).show()
        }

    }
}