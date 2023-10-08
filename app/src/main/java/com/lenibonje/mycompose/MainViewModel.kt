package com.lenibonje.mycompose

import androidx.lifecycle.ViewModel
import com.lenibonje.mycompose.data.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    personRepository: PersonRepository
) : ViewModel() {

    val readAll = personRepository.readAll

}
