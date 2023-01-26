package com.ergea.finalapp.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ergea.finalapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private val viewModel: SplashViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        loadingScreen()
        return view
    }

    private fun loadingScreen() {
        Handler(Looper.getMainLooper()).postDelayed(this::isLogin, 2000)
    }

    private fun isLogin() {
        lifecycleScope.launchWhenCreated {
            viewModel.getIdUser().observe(viewLifecycleOwner) {
                if (it == null || it == 0) {
                    findNavController().navigate(R.id.loginFragment)
                } else {
                    findNavController().navigate(R.id.homeFragment)
                }
            }
        }
    }

}