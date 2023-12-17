package com.romasks.hotel

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.romasks.core.fragment.viewBinding
import com.romasks.hotel.databinding.FragmentHotelBinding

class HotelFragment : Fragment(R.layout.fragment_hotel) {

  private val binding by viewBinding(FragmentHotelBinding::bind)

  private var viewModel: HotelViewModel? = null

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel = ViewModelProvider(this).get(HotelViewModel::class.java)

    val textView: TextView = binding.textHotel
    viewModel?.text?.observe(viewLifecycleOwner) {
      textView.text = it
    }

    binding.openDetailsBtn.setOnClickListener {
      findNavController().navigate(R.id.to_hotel_details)
    }
  }
}