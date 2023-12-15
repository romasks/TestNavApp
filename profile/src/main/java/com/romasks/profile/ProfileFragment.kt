package com.romasks.profile

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.romasks.core.fragment.viewBinding
import com.romasks.profile.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

  private val binding by viewBinding(FragmentProfileBinding::bind)

  private var viewModel: ProfileViewModel? = null

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

    val textView: TextView = binding.textProfile
    viewModel?.text?.observe(viewLifecycleOwner) {
      textView.text = it
    }
  }
}