package com.efedaniel.loggingtextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.efedaniel.loggingtextview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
    }

}