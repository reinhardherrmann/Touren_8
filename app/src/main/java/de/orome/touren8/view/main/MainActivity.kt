package de.orome.touren8.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import de.orome.touren8.R
import de.orome.touren8.databinding.ActivityMainBinding
import de.orome.touren8.view.touren.TourenActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btnActivityMainTouren.setOnClickListener {
            val intent = Intent(this,TourenActivity::class.java)
            startActivity(intent)
        }
    }
}