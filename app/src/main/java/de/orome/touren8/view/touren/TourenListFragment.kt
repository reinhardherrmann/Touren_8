package de.orome.touren8.view.touren

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import de.orome.touren8.R
import de.orome.touren8.databinding.FragmentTourenListBinding

class TourenListFragment: Fragment() {

    private lateinit var binding: FragmentTourenListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTourenListBinding.inflate(layoutInflater,container,false)
        binding.fabAddNewTour.setOnClickListener {
            findNavController().navigate(R.id.action_tourenListFragment_to_tourNewFragment)
        }


        return binding.root
    }
}