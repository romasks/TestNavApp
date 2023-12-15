package com.romasks.room

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.romasks.core.fragment.viewBinding
import com.romasks.room.databinding.FragmentRoomBinding

class RoomFragment : Fragment(R.layout.fragment_room) {

  private val binding by viewBinding(FragmentRoomBinding::bind)

  private var viewModel: RoomViewModel? = null

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel = ViewModelProvider(this).get(RoomViewModel::class.java)

    val textView: TextView = binding.textRoom
    viewModel?.text?.observe(viewLifecycleOwner) {
      textView.text = it
    }
  }
}