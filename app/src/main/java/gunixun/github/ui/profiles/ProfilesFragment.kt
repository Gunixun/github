package gunixun.github.ui.profiles

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import gunixun.github.app
import gunixun.github.databinding.FragmentProfilesBinding
import gunixun.github.domain.entities.Profile
import gunixun.github.ui.BaseFragment
import gunixun.github.ui.utils.AppState

class ProfilesFragment :
    BaseFragment<FragmentProfilesBinding>(FragmentProfilesBinding::inflate) {

    private lateinit var adapter: ProfilesAdapter

    private val viewModel:  ProfilesContract.ViewModel by lazy {
        ProfilesViewModel(requireActivity().app.profilesDataSource)
    }

    companion object {
        fun newInstance() = ProfilesFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
        connectSignals()
        viewModel.getUserAccounts()
    }

    private fun setupUi(){
        adapter = ProfilesAdapter()
        adapter.setOnClick(object : ProfilesAdapter.OnClick {
            override fun onClick(profile: Profile) {
            }
        })

        binding.profilesRecycler.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.profilesRecycler.adapter = adapter

        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.getUserAccounts()
        }
    }


    private fun connectSignals() {
        viewModel.getLiveData().observe(viewLifecycleOwner) { state ->
            renderData(state)
        }
    }

    private fun renderData(result: AppState) {
        binding.swipeToRefresh.isRefreshing = false
        when (result) {
            is AppState.Loading -> {
                with(binding) {
                    emptyTextView.isVisible = false
                    swipeToRefresh.isRefreshing = true
                }
            }
            is AppState.SuccessProfiles -> {
                binding.emptyTextView.isVisible = result.profiles.isEmpty()
                adapter.setData(result.profiles)
            }
            is AppState.Error -> {
                binding.emptyTextView.isVisible = true
            }
            else -> {}
        }
    }


}