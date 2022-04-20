package gunixun.github.ui.profiles

import androidx.lifecycle.MutableLiveData
import gunixun.github.ui.utils.AppState

class ProfilesContract {

    interface ViewModel  {
        fun getLiveData() : MutableLiveData<AppState>
        fun getUserAccounts()
    }
}