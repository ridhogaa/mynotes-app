package com.ergea.finalapp.ui.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.ergea.finalapp.R
import com.ergea.finalapp.databinding.FragmentUpdateDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateDialogFragment : DialogFragment() {

    private val viewModel: UpdateDialogViewModel by activityViewModels()
    private var _binding: FragmentUpdateDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpdateDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        binding.btnEdit.setOnClickListener {
            viewModel.getIdUser().observe(viewLifecycleOwner) {
                viewModel.updateNote(
                    title = binding.etUpdateTitle.text.toString().trim(),
                    desc = binding.etUpdateDescription.text.toString().trim(),
                    id_note = arguments?.getInt("ID_NOTE")!!,
                    id_user = it
                )
            }
            Toast.makeText(requireContext(), "Update Note Success", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.homeFragment)
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}