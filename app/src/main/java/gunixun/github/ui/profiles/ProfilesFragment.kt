package gunixun.github.ui.profiles

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import gunixun.github.R
import gunixun.github.app
import gunixun.github.databinding.FragmentProfilesBinding
import gunixun.github.domain.entities.Profile
import gunixun.github.ui.BaseFragment
import gunixun.github.ui.NavigationActivity
import gunixun.github.ui.profile_details.ProfileDetailsFragment
import gunixun.github.ui.utils.AppState
import gunixun.github.ui.utils.createErrSnackBar
import gunixun.github.ui.utils.createMsgSnackBar
import gunixun.github.ui.utils.hideSnackBar

class ProfilesFragment :
    BaseFragment<FragmentProfilesBinding>(FragmentProfilesBinding::inflate) {

    private lateinit var adapter: ProfilesAdapter

    private val viewModel: ProfilesContract.ViewModel by lazy {
        ProfilesViewModel(requireActivity().app.profilesDataSource)
    }

    private var retryIter: Int = 0
    private var snackBar: Snackbar? = null

    companion object {
        fun newInstance() = ProfilesFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
        connectSignals()
        viewModel.getUserAccounts()

    }

    private fun setupUi() {
        adapter = ProfilesAdapter()
        adapter.setOnClick(object : ProfilesAdapter.OnClick {
            override fun onClick(profile: Profile) {
                activity?.let {
                    if (it is NavigationActivity) {
                        it.navigationTo(ProfileDetailsFragment.newInstance(profile), true)
                    }
                }
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
                hideSnackBar(snackBar)
                with(binding) {
                    emptyTextView.isVisible = false
                    swipeToRefresh.isRefreshing = true
                }
            }
            is AppState.SuccessProfiles -> {
                retryIter = 0
                binding.emptyTextView.isVisible = result.profiles.isEmpty()
                adapter.setData(result.profiles)
            }
            is AppState.Error -> {
                binding.emptyTextView.isVisible = true
                if (retryIter < 3) {
                    snackBar = binding.root.createErrSnackBar(
                        text = result.error.toString(),
                        actionText = R.string.retry,
                        { viewModel.getUserAccounts() }
                    )
                    snackBar?.show()
                } else {
                    binding.root.createMsgSnackBar(
                        text = this.resources.getString(R.string.fall_load_data)
                    ).show()
                }
                retryIter++
            }
            else -> {}
        }
    }

}