package com.ergea.finalapp.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.ergea.finalapp.R
import com.ergea.finalapp.data.local.database.entity.UserEntity
import com.ergea.finalapp.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private val viewModel: RegisterViewModel by activityViewModels()
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        register()
    }

    private fun register() {
        binding.btnRegister.setOnClickListener {
            val email = binding.etEmailRegister.text.toString().trim()
            val password = binding.etPasswordRegister.text.toString().trim()
            val cPassword = binding.etKonfirmPasswordRegister.text.toString().trim()
            if (viewModel.checkEmailIfExist(email)) {
                Toast.makeText(requireContext(), "Email already registered", Toast.LENGTH_LONG)
                    .show()
            } else {
                if (password == cPassword) {
                    viewModel.registerUser(UserEntity(email = email, password = password))
                    Toast.makeText(requireContext(), "Register Success", Toast.LENGTH_LONG)
                        .show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                } else {
                    Toast.makeText(requireContext(), "Password not match", Toast.LENGTH_LONG)
                        .show()
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}