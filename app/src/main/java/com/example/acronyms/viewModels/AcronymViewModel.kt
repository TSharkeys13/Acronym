package com.example.acronyms.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acronyms.R
import com.example.acronyms.models.AcronymRepository
import com.example.acronyms.view.AcronymScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.serialization.SerializationException
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class AcronymViewModel @Inject constructor(private val repo: AcronymRepository) : ViewModel() {
    private val _state = MutableLiveData(AcronymScreenState())
    val state: LiveData<AcronymScreenState> get() = _state

    var input = MutableLiveData("")

    private val handler = CoroutineExceptionHandler { _, throwable ->
        val errorText = when (throwable) {
            is SerializationException -> R.string.serialization
            is IOException -> R.string.io
            is HttpException -> R.string.http
            else -> R.string.general_error
        }
        _state.value = _state.value?.copy(isLoading = false, showResultText = false, errorTextId = errorText)
    }

    fun getWordsFromAcronym() = viewModelScope.launch(handler) {
        _state.value = _state.value?.copy(isLoading = true)
        val words = repo.getWordsFromAcronym(input.value!!)
        _state.value = _state.value?.copy(isLoading = false, response = words, showResultText = true)
    }
}
