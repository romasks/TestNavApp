package com.romasks.hotel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HotelViewModel : ViewModel() {

  private val _text = MutableLiveData<String>().apply {
    value = "This is hotel Fragment"
  }
  val text: LiveData<String> = _text
}