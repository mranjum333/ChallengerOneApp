package com.android.challengeroneapp.view.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.challengeroneapp.R
import com.android.challengeroneapp.data.db.entity.ProfileEntity
import com.android.challengeroneapp.databinding.FragmentUserProfileBinding
import com.android.challengeroneapp.viewmodel.ProfileDataViewModel

class UserProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentUserProfileBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_user_profile, container, false)

        viewModel =  ViewModelProvider(this).get(ProfileDataViewModel::class.java)
        viewModel.getProfileData().observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.profile = it[0]
            }
        })
        return binding.root
    }
}