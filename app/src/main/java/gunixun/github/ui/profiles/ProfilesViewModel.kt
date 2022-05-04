package gunixun.github.ui.profiles

import androidx.lifecycle.MutableLiveData
import gunixun.github.domain.use_cases.ProfilesUseCase
import gunixun.github.ui.utils.AppState
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class ProfilesViewModel(
    private val profilesDataSource: ProfilesUseCase
) : ProfilesViewModelAbs() {

    private val liveData: MutableLiveData<AppState> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun getLiveData(): MutableLiveData<AppState> = liveData

    override fun getUserAccounts() {
        liveData.postValue(AppState.Loading)
        compositeDisposable.add(
            profilesDataSource
                .getProfiles()
                .subscribeBy(
                    onSuccess = {
                        liveData.postValue(AppState.SuccessProfiles(it))
                    },
                    onError = {
                        liveData.postValue(AppState.Error(it))
                    })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}