package com.ergea.finalapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ergea.finalapp.R
import com.ergea.finalapp.data.local.database.entity.NoteEntity
import com.ergea.finalapp.databinding.FragmentHomeBinding
import com.ergea.finalapp.ui.delete.DeleteDialogFragment
import com.ergea.finalapp.ui.update.UpdateDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeAdapter.ItemClickListener {

    private val viewModel: HomeViewModel by activityViewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        logout()
    }

    private fun logout() {
        binding.btnLogout.setOnClickListener {
            viewModel.clear()
            it.findNavController().navigate(R.id.loginFragment)
        }
    }

    private fun observeData() {
        viewModel.getIdUser().observe(viewLifecycleOwner) {
            viewModel.fetchingNotes(it)
            viewModel.fetchingUser(it)
        }
        viewModel.user.observe(viewLifecycleOwner) {
            binding.hi.text = "Hi, ${it.email}"
        }
        viewModel.notes.observe(viewLifecycleOwner) {
            binding.rvListNotes.layoutManager = LinearLayoutManager(requireContext())
            binding.rvListNotes.adapter = HomeAdapter(it, this@HomeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun editClicked(noteEntity: NoteEntity) {
        val bundle = Bundle()
        bundle.putInt("ID_NOTE", noteEntity.idNote!!)
        val updateDialog = UpdateDialogFragment()
        updateDialog.arguments = bundle
        updateDialog.show(parentFragmentManager, "edit")
    }

    override fun deleteClicked(noteEntity: NoteEntity) {
        val bundle = Bundle()
        bundle.putInt("ID_NOTE", noteEntity.idNote!!)
        val deleteDialog = DeleteDialogFragment()
        deleteDialog.arguments = bundle
        deleteDialog.show(parentFragmentManager, "delete")
    }
}