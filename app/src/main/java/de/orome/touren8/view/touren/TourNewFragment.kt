package de.orome.touren8.view.touren

import android.app.DatePickerDialog
import android.app.TimePickerDialog
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
import java.util.*

class TourNewFragment: Fragment() {

    private lateinit var binding: FragmentTourNewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val helper = Helper()
        var dat: String = " "
        var std: String = ""
        var minute: String = ""
        var tag: String = ""
        var monat: String = ""

        binding = FragmentTourNewBinding.inflate(layoutInflater,container,false)


        // KlickListener für die Felder zur Anzeige von Dialogen
        binding.apply {
            etNewTourTourDatum.setOnLongClickListener {
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                val dpd = DatePickerDialog(
                    requireContext(), DatePickerDialog.OnDateSetListener { v, year, month, day ->

                        //val helper
                        tag = helper.modifyMinuteHourDayMonth(day)
                        monat = helper.modifyMinuteHourDayMonth(month + 1)

                        dat = tag + "." + monat + "." + year.toString()
                        etNewTourTourDatum.setText(dat)
                    }, year, month, day
                )
                dpd.show()
                return@setOnLongClickListener true
            }
            etNewTourTourDauer.setOnLongClickListener {
                // Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
                val c = Calendar.getInstance()
                val hh = 3 //c.get(Calendar.HOUR_OF_DAY)
                val mm = 25 //c.get(Calendar.MINUTE)

                val dpd = TimePickerDialog(
                    requireContext(), TimePickerDialog.OnTimeSetListener { v, hh, mm ->
                        if (hh < 10) {
                        }

                        // Zeitwerte auf 2-Stellige Anzeige umschalten
                        std = helper.modifyMinuteHourDayMonth(hh)
                        minute = helper.modifyMinuteHourDayMonth(mm)
                        dat = "$std:$minute"

                        etNewTourTourDauer.setText(dat)
                    }, hh, mm, true
                )
                dpd.show()
                return@setOnLongClickListener true
            }
            etNewTourTourDepotzeitVt.setOnLongClickListener {
                // Standardzeit für Tourdauer auf 01:25 in Shared Preferences setzen
                val c = Calendar.getInstance()
                val hh = 1 //c.get(Calendar.HOUR_OF_DAY)
                val mm = 25 //c.get(Calendar.MINUTE)

                val dpd = TimePickerDialog(
                    requireContext(), TimePickerDialog.OnTimeSetListener { v, hh, mm ->
                        if (hh < 10) {
                        }

                        // Zeitwerte auf 2-Stellige Anzeige umschalten
                        std = helper.modifyMinuteHourDayMonth(hh)
                        minute = helper.modifyMinuteHourDayMonth(mm)
                        dat = "$std:$minute"

                        etNewTourTourDepotzeitVt.setText(dat)
                    }, hh, mm, true
                )
                dpd.show()
                return@setOnLongClickListener true
            }
            etNewTourTourDepotzeitNt.setOnLongClickListener {
                // Standardzeit für Tourdauer auf 00:25 in Shared Preferences setzen
                val c = Calendar.getInstance()
                val hh = 0 //c.get(Calendar.HOUR_OF_DAY)
                val mm = 25 //c.get(Calendar.MINUTE)

                val dpd = TimePickerDialog(
                    requireContext(), TimePickerDialog.OnTimeSetListener { v, hh, mm ->
                        if (hh < 10) {
                        }

                        // Zeitwerte auf 2-Stellige Anzeige umschalten
                        std = helper.modifyMinuteHourDayMonth(hh)
                        minute = helper.modifyMinuteHourDayMonth(mm)
                        dat = "$std:$minute"

                        etNewTourTourDepotzeitNt.setText(dat)
                    }, hh, mm, true
                )
                dpd.show()
                return@setOnLongClickListener true
            }
//            etNewTourTourFahrerNummer.setOnLongClickListener {
//                Toast.makeText(requireContext(),"Fahrernummer",Toast.LENGTH_LONG).show()
//                return@setOnLongClickListener true
//            }
//            etNewTourTourFahrzeugNummer.setOnLongClickListener {
//                Toast.makeText(requireContext(),"Fahrzeugnummer",Toast.LENGTH_LONG).show()
//                return@setOnLongClickListener true
//            }

            btnNewTourCancel.setOnClickListener {
                //viewModel.clearAllFieldValues()
                Log.i("DEBUG", "Eingabe der neuen Tour abgebrochen")
                findNavController().navigate(R.id.action_tourNewFragment_to_tourenListFragment)
            }
            btnNewTourSave.setOnClickListener {
                Log.i("DEBUG", "Daten gespeichert")
                val uID = helper.getUUId()
                Log.i("DEBUG", "UUId: $uID")
                findNavController().navigate(R.id.action_tourNewFragment_to_tourenListFragment)
            }
        }


        return binding.root
    }



}