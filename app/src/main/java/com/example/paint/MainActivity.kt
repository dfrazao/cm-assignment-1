package com.example.paint

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val settings = getSharedPreferences("settings", 0)
        val color = settings.getString("background-color", "white")

        if (color == "white") {
            Log.d("testeIf", ""+ color)
        } else {
            Log.d("testeElse", ""+ color)
        }

        when (color) {
            "white" -> {
                window.decorView.setBackgroundColor(Color.WHITE);
            }
            "red" -> {
                window.decorView.setBackgroundColor(Color.RED);
            }
            "green" -> {
                window.decorView.setBackgroundColor(Color.GREEN);
            }
            "blue" -> {
                window.decorView.setBackgroundColor(Color.BLUE);
            }
            "yellow" -> {
                window.decorView.setBackgroundColor(Color.YELLOW);
            }
            "cyan" -> {
                window.decorView.setBackgroundColor(Color.CYAN);
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miAbout -> startActivity(Intent(this, AboutActivity::class.java))
            R.id.miSettings -> startActivity(Intent(this, SettingsActivity::class.java))
        }
        return true
    }
}