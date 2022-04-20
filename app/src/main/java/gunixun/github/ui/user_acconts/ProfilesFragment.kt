package gunixun.github.ui.user_acconts

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import gunixun.github.app
import gunixun.github.databinding.FragmentProfilesBinding
import gunixun.github.ui.BaseFragment
import gunixun.github.ui.utils.AppState

class ProfilesFragment :
    BaseFragment<FragmentProfilesBinding>(FragmentProfilesBinding::inflate) {

    private val viewModel:  ProfilesContract.ViewModel by lazy {
        ProfilesViewModel(requireActivity().app.profilesDataSource)
    }

    companion object {
        fun newInstance() = ProfilesFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        connectSignals()
        viewModel.getUserAccounts()
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
                binding.emptyTextView.isVisible = true
            }
            is AppState.Error -> {
                binding.emptyTextView.isVisible = true
            }
            else -> {}
        }
    }


}