package br.com.portfolioapp.ui.view.onboarding.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import br.com.portfolioapp.R
import br.com.portfolioapp.databinding.FragmentOnboardingBinding
import br.com.portfolioapp.ui.view.BaseFragment

class OnboardingFragment: BaseFragment<FragmentOnboardingBinding>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindView(inflater, container, R.layout.fragment_onboarding)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnLetsGo.setOnClickListener { view ->
            val directions = OnboardingFragmentDirections.actionOnboardingFragmentToRegisterFragment()
            view.findNavController().navigate(directions)
        }
    }
}