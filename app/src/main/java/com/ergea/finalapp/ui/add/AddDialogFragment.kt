package com.ergea.finalapp.ui.add

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.ergea.finalapp.R
import com.ergea.finalapp.data.local.database.entity.NoteEntity
import com.ergea.finalapp.databinding.FragmentAddDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddDialogFragment : DialogFragment() {

    private val viewModel: AddDialogViewModel by activityViewModels()
    private var _binding: FragmentAddDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        binding.btnAdd.setOnClickListener {
            viewModel.getIdUser().observe(viewLifecycleOwner) { idUser ->
                viewModel.addNote(
                    NoteEntity(
                        idUser = idUser,
                        title = binding.etAddTitle.text.toString().trim(),
                        description = binding.etAddDescription.text.toString().trim()
                    )
                )
            }
            Toast.makeText(requireContext(), "Add Note Success", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.homeFragment)
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}