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
import kotlinx.android.synthetic.main.fragment_signup.*

class SignupFragment : Fragment() {

    private lateinit var viewModel: SignupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signupBtn.setOnClickListener { onSignup(it) }
        gotoLoginBtn.setOnClickListener { onGotoLogin(it) }

        viewModel = ViewModelProvider(this).get(SignupViewModel::class.java)
        observeViewModel()
    }

    private fun observeViewModel() {

        viewModel.signupComplete.observe(viewLifecycleOwner, Observer { isComplete ->

        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->

        })
    }

    private fun onSignup(v: View) {
        val action = SignupFragmentDirections.actionGoToHome()
        Navigation.findNavController(v).navigate(action)
    }

    private fun onGotoLogin(v: View) {
        val action = SignupFragmentDirections.actionGoToLogin()
        Navigation.findNavController(v).navigate(action)
    }

}