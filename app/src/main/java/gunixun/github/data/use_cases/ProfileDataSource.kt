package gunixun.github.data.use_cases

import gunixun.github.domain.IGitHubApi
import gunixun.github.domain.entities.Profile
import gunixun.github.domain.use_cases.ProfileUseCase
import gunixun.github.utils.CallbackData


class ProfileDataSource(
    private val api: IGitHubApi
) : ProfileUseCase {

    override fun getProfile(
        login: String,
        callback: CallbackData<Profile>
    ) {
        Thread {
            try {
                callback.onSuccess(
                    api.getProfile(login)
                )
            } catch (exc: Exception) {
                callback.onError(exc)
            }
        }.start()
    }
}