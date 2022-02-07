package de.orome.touren8.view.touren

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import de.orome.touren7.helper.Helper
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


        // KlickListener für die Felder zur Anzeige von Dialogen
        binding.apply {
            etNewTourTourDatum.setOnLongClickListener {
                Toast.makeText(requireContext(),"Datum",Toast.LENGTH_LONG).show()
                return@setOnLongClickListener true
            }
            etNewTourTourDauer.setOnLongClickListener {
                Toast.makeText(requireContext(),"Dauer",Toast.LENGTH_LONG).show()
                return@setOnLongClickListener true
            }
            etNewTourTourDepotzeitVt.setOnLongClickListener {
                Toast.makeText(requireContext(),"Depotzeit vt",Toast.LENGTH_LONG).show()
                return@setOnLongClickListener true
            }
            etNewTourTourDepotzeitNt.setOnLongClickListener {
                Toast.makeText(requireContext(),"-depotzeit nt",Toast.LENGTH_LONG).show()
                return@setOnLongClickListener true
            }
            etNewTourTourFahrerNummer.setOnLongClickListener {
                Toast.makeText(requireContext(),"Fahrernummer",Toast.LENGTH_LONG).show()
                return@setOnLongClickListener true
            }
            etNewTourTourFahrzeugNummer.setOnLongClickListener {
                Toast.makeText(requireContext(),"Fahrzeugnummer",Toast.LENGTH_LONG).show()
                return@setOnLongClickListener true
            }

            btnNewTourCancel.setOnClickListener {
                //viewModel.clearAllFieldValues()
                Log.i("DEBUG", "Eingabe der neuen Tour abgebrochen")
                findNavController().navigate(R.id.action_tourNewFragment_to_tourenListFragment)
            }
            btnNewTourSave.setOnClickListener {
                Log.i("DEBUG", "Daten gespeichert")
                val helper = Helper()
                val uID = helper.getUUId()
                Log.i("DEBUG", "UUId: $uID")
                findNavController().navigate(R.id.action_tourNewFragment_to_tourenListFragment)
            }
        }


        return binding.root
    }



}