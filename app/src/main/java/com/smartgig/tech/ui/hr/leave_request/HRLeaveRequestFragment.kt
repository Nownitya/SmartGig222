package com.smartgig.tech.ui.hr.leave_request

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smartgig.tech.databinding.FragmentHrLeaveRequestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HRLeaveRequestFragment : Fragment() {

    private var _binding: FragmentHrLeaveRequestBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHrLeaveRequestBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    companion object {

    }
}