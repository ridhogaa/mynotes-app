package com.ergea.finalapp.ui.delete

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
import com.ergea.finalapp.databinding.FragmentDeleteDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeleteDialogFragment : DialogFragment() {

    private var _binding: FragmentDeleteDialogBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DeleteDialogViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeleteDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        binding.btnDelete.setOnClickListener {
            viewModel.getIdUser().observe(viewLifecycleOwner) {
                viewModel.deleteNote(arguments?.getInt("ID_NOTE")!!, it)
            }
            Toast.makeText(requireContext(), "Delete Note Success", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.homeFragment)
            dismiss()
        }
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
//        binding.btnDelete.setOnClickListener {
//            homeViewModel.deleteNotes(notesEntity)
//            Constants.showMessage("Notes Berhasil Dihapus!", requireContext())
//            dismiss()
//        }
//
//        binding.btnCancel.setOnClickListener {
//            dismiss()
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}