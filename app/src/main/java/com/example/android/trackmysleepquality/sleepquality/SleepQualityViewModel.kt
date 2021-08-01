package com.example.android.trackmysleepquality.sleepquality

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.trackmysleepquality.database.SleepDatabaseDao
import kotlinx.coroutines.launch

class SleepQualityViewModel(
    private val sleepNightKey: Long = 0L,
    val database: SleepDatabaseDao
) : ViewModel() {

    private val _navigateToSleepTracker = MutableLiveData<Boolean?>()

    val navigateToSleepTracker: LiveData<Boolean?>
        get() = _navigateToSleepTracker

    init {
        _navigateToSleepTracker.value = false
    }

    fun doneNavigating() {
        _navigateToSleepTracker.value = false
    }

    fun onSetSleepQuality(quality: Int) {
        viewModelScope.launch {
            val tonight = database.get(sleepNightKey) ?: return@launch
            tonight.sleepQuality = quality
            database.update(tonight)
            _navigateToSleepTracker.value = true
        }
    }

    /**
     * fun onSetSleepQuality(quality: Int) {
    uiScope.launch {
    withContext(Dispatchers.IO) {
    val tonight = database.get(sleepNightKey) ?: return@withContext
    tonight.sleepQuality = quality
    database.update(tonight)
    }
    _navigateToSleepTracker.value = true
    }
    }
     *
     */

    override fun onCleared() {
        super.onCleared()
        Log.d("Lord Krishna", "All cleared")
    }
}