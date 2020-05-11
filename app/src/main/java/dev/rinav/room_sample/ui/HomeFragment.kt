package dev.rinav.room_sample.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import dev.rinav.R
import dev.rinav.room_sample.data.model.LoginState
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

        usernameTV.text = LoginState.user?.username

        signoutBtn.setOnClickListener { onSignout() }
        deleteUserBtn.setOnClickListener { onDelete() }

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        observeViewModel()
    }

    private fun observeViewModel() {

        viewModel.signout.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, "Signed out", Toast.LENGTH_SHORT).show()
            goToSignUpScreen()
        })

        viewModel.userDeleted.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, "User deleted", Toast.LENGTH_SHORT).show()
            goToSignUpScreen()
        })
    }

    private fun onSignout() {
        viewModel.onSignout()
    }

    private fun onDelete() {

        AlertDialog.Builder(requireActivity())
            .setTitle("Delete user")
            .setMessage("Are you sure you want to delete this user?")
            .setPositiveButton("Yes") { _, linstener -> viewModel.onDeleteUser() }
            .setNegativeButton("Cancel", null)
            .create()
            .show()

    }

    private fun goToSignUpScreen() {
        val action = HomeFragmentDirections.actionGoToSignup()
        Navigation.findNavController(usernameTV).navigate(action)
    }
}
