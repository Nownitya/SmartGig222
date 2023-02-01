package com.smartgig.tech.ui.admin.leave_request

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smartgig.tech.R
import com.smartgig.tech.databinding.FragmentAdminHomeBinding
import com.smartgig.tech.databinding.FragmentAdminLeaveRequestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminLeaveRequestFragment : Fragment() {

    private var _binding: FragmentAdminLeaveRequestBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAdminLeaveRequestBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

    }
}