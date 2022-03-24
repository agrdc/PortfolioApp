package br.com.portfolioapp.ui.view.onboarding.fragment

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import br.com.portfolioapp.R
import br.com.portfolioapp.databinding.FragmentRegisterBinding
import br.com.portfolioapp.ui.view.BaseFragment
import br.com.portfolioapp.ui.viewmodel.onboarding.RegisterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    private val viewModel: RegisterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindView(inflater, container, R.layout.fragment_register)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        observeLiveDatas()
    }

    private fun observeLiveDatas() {
        viewModel.validationErrorLiveData.observe(viewLifecycleOwner) { error ->
            binding.tilName.error = error
            binding.btnUnderstood.isEnabled = viewModel.handleButtonEnabled(error)
        }
    }

    private fun setupListeners() {
        binding.etName.backActionListener = {
            viewModel.validateField(binding.etName.text.toString())
        }
        binding.etName.setOnEditorActionListener { _, actionId, keyEvent ->
            if (keyEvent?.keyCode == KeyEvent.FLAG_EDITOR_ACTION || actionId == EditorInfo.IME_ACTION_DONE) {
                viewModel.validateField(binding.etName.text.toString())
            }
            false
        }
        binding.btnUnderstood.setOnClickListener {
            viewModel.saveUsername(binding.etName.text.toString())
        }
    }
}