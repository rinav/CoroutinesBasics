package dev.rinav.room_sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import dev.rinav.R
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginBtn.setOnClickListener { onLogin(it) }
        gotoSignupBtn.setOnClickListener { onGotoSignup(it) }

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.loginComplete.observe(viewLifecycleOwner, Observer { isComplete ->

        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->


        })
    }

    private fun onLogin(v: View) {
        val action = LoginFragmentDirections.actionGoToHome()
        Navigation.findNavController(v).navigate(action)
    }

    private fun onGotoSignup(v: View) {
        val action = LoginFragmentDirections.actionGoToSignup()
        Navigation.findNavController(v).navigate(action)
    }
}