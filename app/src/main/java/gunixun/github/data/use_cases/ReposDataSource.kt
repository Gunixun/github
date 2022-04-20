package gunixun.github.data.use_cases

import gunixun.github.domain.IGitHubApi
import gunixun.github.domain.entities.Repo
import gunixun.github.domain.use_cases.ReposUseCase
import gunixun.github.utils.CallbackData


class ReposDataSource(
    private val api: IGitHubApi
) : ReposUseCase {

    override fun getRepos(
        loginProfile: String,
        callback: CallbackData<List<Repo>>
    ) {
        Thread {
            try {
                callback.onSuccess(
                    api.getRepos(loginProfile)
                )
            } catch (exc: Exception) {
                callback.onError(exc)
            }
        }.start()
    }
}