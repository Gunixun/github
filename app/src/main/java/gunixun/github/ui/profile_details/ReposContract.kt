package gunixun.github.ui.profile_details

import androidx.lifecycle.MutableLiveData
import gunixun.github.ui.utils.AppState

class ReposContract {

    interface ViewModel  {
        fun getLiveData() : MutableLiveData<AppState>
        fun getRepos(loginProfile: String)
    }
}