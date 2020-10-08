package com.example.paint

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*


class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val settings = getSharedPreferences("settings", 0)
        val color = settings.getString("background-color", "white")

        when (color) {
            "white" -> {
                color_white.setChecked(true)
            }
            "red" -> {
                color_red.setChecked(true)
            }
            "green" -> {
                color_green.setChecked(true)
            }
            "blue" -> {
                color_blue.setChecked(true)
            }
            "yellow" -> {
                color_yellow.setChecked(true)
            }
            "cyan" -> {
                color_cyan.setChecked(true)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_not_main, menu)
        return true
    }

    // Handle radio button
    fun onRadioButtonClicked(view: View) {
        val settings = getSharedPreferences("settings", 0)
        val editor = settings.edit()
        when (view.id) {
            R.id.color_white -> {
                editor.putString("background-color", "white")
            }
            R.id.color_red -> {
                editor.putString("background-color", "red")
            }
            R.id.color_green -> {
                editor.putString("background-color", "green")
            }
            R.id.color_blue -> {
                editor.putString("background-color", "blue")
            }
            R.id.color_yellow -> {
                editor.putString("background-color", "yellow")
            }
            R.id.color_cyan -> {
                editor.putString("background-color", "cyan")
            }
        }
        editor.commit() // Commit the changes

        val BACKGORUND_NAME = "background_color"
        val BACKGORUND_COLOR: String? = settings.getString("background-color", "white")

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(BACKGORUND_NAME, BACKGORUND_COLOR)
        startActivity(intent)
    }

}