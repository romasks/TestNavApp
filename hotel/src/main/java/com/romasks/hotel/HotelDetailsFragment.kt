package com.romasks.hotel

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.romasks.core.fragment.viewBinding
import com.romasks.hotel.databinding.FragmentHotelDetailsBinding

class HotelDetailsFragment : Fragment(R.layout.fragment_hotel_details) {

  private val binding by viewBinding(FragmentHotelDetailsBinding::bind)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.backBtn.setOnClickListener {
      findNavController().navigateUp()
    }
  }
}