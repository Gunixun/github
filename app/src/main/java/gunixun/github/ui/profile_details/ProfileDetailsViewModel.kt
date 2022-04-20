package gunixun.github.ui.profile_details

import androidx.lifecycle.MutableLiveData
import gunixun.github.domain.entities.Profile
import gunixun.github.domain.entities.Repo
import gunixun.github.domain.use_cases.ProfileUseCase
import gunixun.github.domain.use_cases.ReposUseCase
import gunixun.github.ui.utils.AppState
import gunixun.github.utils.CallbackData

class ProfileDetailsViewModel(
    private val reposDataSource: ReposUseCase
) : ProfileDetailsContract.ViewModel {

    private val liveData: MutableLiveData<AppState> = MutableLiveData()

    override fun getLiveData(): MutableLiveData<AppState> = liveData

    override fun getRepos(loginProfile: String) {
        liveData.postValue(AppState.Loading)
        reposDataSource.getRepos(loginProfile, object : CallbackData<List<Repo>> {
            override fun onSuccess(result: List<Repo>) {
                liveData.postValue(AppState.SuccessRepos(result))
            }
            override fun onError(error: Exception) {
                liveData.postValue(AppState.Error(error))
            }
        })
    }

}