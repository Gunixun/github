package gunixun.github.ui.profile_details

import androidx.lifecycle.MutableLiveData
import gunixun.github.domain.use_cases.ReposUseCase
import gunixun.github.ui.utils.AppState
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class ReposViewModel(
    private val reposDataSource: ReposUseCase
) : ReposContract.ViewModel {

    private val liveData: MutableLiveData<AppState> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun getLiveData(): MutableLiveData<AppState> = liveData

    override fun getRepos(loginProfile: String) {
        liveData.postValue(AppState.Loading)

        compositeDisposable.add(
            reposDataSource
                .getRepos(loginProfile)
                .subscribeBy(
                    onSuccess = {
                        liveData.postValue(AppState.SuccessRepos(it))
                    },
                    onError = {
                        liveData.postValue(AppState.Error(it))
                    })
        )
    }

}