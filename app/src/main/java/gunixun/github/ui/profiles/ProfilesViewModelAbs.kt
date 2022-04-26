package gunixun.github.ui.profiles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gunixun.github.ui.utils.AppState

abstract class ProfilesViewModelAbs: ViewModel() {
    abstract fun getLiveData() : MutableLiveData<AppState>
    abstract fun getUserAccounts()

}