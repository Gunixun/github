package gunixun.github.ui.user_acconts

import androidx.lifecycle.MutableLiveData
import gunixun.github.ui.utils.AppState

class UserAccountsViewModel : UserAccountsContract.ViewModel{

    private val liveData: MutableLiveData<AppState> = MutableLiveData()

    override fun getLiveData(): MutableLiveData<AppState> = liveData

}