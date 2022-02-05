package de.orome.touren8.view.touren


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import de.orome.touren8.R
import de.orome.touren8.databinding.ActivityTourenBinding



class TourenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTourenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_touren)
    }


}