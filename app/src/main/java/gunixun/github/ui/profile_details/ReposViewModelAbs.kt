package gunixun.github.ui.profile_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import gunixun.github.ui.utils.AppState

abstract class ReposViewModelAbs: ViewModel()  {
    abstract fun getLiveData() : MutableLiveData<AppState>
    abstract fun getRepos(loginProfile: String)
}