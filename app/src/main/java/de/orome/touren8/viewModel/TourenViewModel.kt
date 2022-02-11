package de.orome.touren8.viewModel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.orome.touren7.helper.Event
import de.orome.touren8.model.database.entity.Tour
import de.orome.touren8.model.repositories.TourenRepository
import kotlinx.coroutines.launch

class TourenViewModel(private val tourenRepository: TourenRepository): ViewModel(), Observable {

    val tourenLiveList = tourenRepository.allLiveTouren

    @Bindable
    val inputNewTourNummer = MutableLiveData<String?>()
    @Bindable
    val inputNewTourDatum = MutableLiveData<String?>()
    @Bindable
    val inputNewTourDauer = MutableLiveData<String?>()
    @Bindable
    val inputNewTourDepotzeit_VT = MutableLiveData<String?>()
    @Bindable
    val inputNewTourDepotzeit_NT = MutableLiveData<String?>()
    @Bindable
    val inputNewTourFahrerNummer = MutableLiveData<String?>()
    @Bindable
    val inputNewTourFahrzeugNummer = MutableLiveData<String?>()


    // Meldungen um mit der View zu kommunizieren
    private val statusMessage = MutableLiveData<Event<String>>()
    val _statusMessage: LiveData<Event<String>>
        get() = statusMessage






    // Funktion, um Tour mit Startwerten zu speichern

    fun insertNewTour(tour: Tour) = viewModelScope.launch {
        val newRowID = tourenRepository.insertTour(tour)
        if (newRowID > -1){
            statusMessage.value = Event("Tour ${tour.tourNummer} mit ID $newRowID gespeichert.")
        } else {
            statusMessage.value = Event("Fehler beim Speichern der Tour!")
        }
    }

































    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}