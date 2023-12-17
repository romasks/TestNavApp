package com.romasks.bookingapp.ui.settings

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.romasks.bookingapp.R
import com.romasks.bookingapp.databinding.FragmentSettingsBinding
import com.romasks.core.fragment.viewBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {

  private val binding by viewBinding(FragmentSettingsBinding::bind)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val textView: TextView = binding.textSettings
  }
}