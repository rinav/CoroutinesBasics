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
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signoutBtn.setOnClickListener { onSignout() }
        deleteUserBtn.setOnClickListener { onDelete() }

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.signout.observe(viewLifecycleOwner, Observer {

        })
        viewModel.userDeleted.observe(viewLifecycleOwner, Observer {

        })
    }

    private fun onSignout() {
        val action = HomeFragmentDirections.actionGoToSignup()
        Navigation.findNavController(usernameTV).navigate(action)
    }

    private fun onDelete() {
        val action = HomeFragmentDirections.actionGoToSignup()
        Navigation.findNavController(usernameTV).navigate(action)
    }
}