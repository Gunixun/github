package gunixun.github.ui.user_acconts

import androidx.lifecycle.MutableLiveData
import gunixun.github.ui.utils.AppState

class UserAccountsContract {

    interface ViewModel  {
        fun getLiveData() : MutableLiveData<AppState>
    }
}