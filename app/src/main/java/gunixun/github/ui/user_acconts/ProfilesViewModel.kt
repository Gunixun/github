package gunixun.github.ui.user_acconts

import androidx.lifecycle.MutableLiveData
import gunixun.github.domain.entities.Profile
import gunixun.github.domain.use_cases.ProfilesUseCase
import gunixun.github.ui.utils.AppState
import gunixun.github.utils.CallbackData

class ProfilesViewModel(
    private val profilesDataSource: ProfilesUseCase
) : ProfilesContract.ViewModel {

    private val liveData: MutableLiveData<AppState> = MutableLiveData()

    override fun getLiveData(): MutableLiveData<AppState> = liveData

    override fun getUserAccounts() {
        liveData.postValue(AppState.Loading)
        profilesDataSource.getProfiles(object : CallbackData<List<Profile>> {
            override fun onSuccess(result: List<Profile>) {
                liveData.postValue(AppState.SuccessProfiles(result))
            }
            override fun onError(error: Exception) {
                liveData.postValue(AppState.Error(error))
            }
        })
    }

}