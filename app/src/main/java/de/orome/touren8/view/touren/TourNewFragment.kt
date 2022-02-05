package de.orome.touren8.view.touren

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.orome.touren8.R
import de.orome.touren8.databinding.FragmentTourNewBinding

class TourNewFragment: Fragment() {

    private lateinit var binding: FragmentTourNewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTourNewBinding.inflate(layoutInflater,container,false)





        return binding.root
    }

}