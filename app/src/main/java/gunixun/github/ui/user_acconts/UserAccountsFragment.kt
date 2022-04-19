package gunixun.github.ui.user_acconts

import gunixun.github.databinding.FragmentUserAccontsBinding
import gunixun.github.ui.BaseFragment

class UserAccountsFragment :
    BaseFragment<FragmentUserAccontsBinding>(FragmentUserAccontsBinding::inflate) {

    companion object {
        fun newInstance() = UserAccountsFragment()
    }
}