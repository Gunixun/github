package gunixun.github.data.use_cases

import gunixun.github.domain.IGitHubApi
import gunixun.github.domain.entities.Profiles
import gunixun.github.domain.use_cases.ProfilesUseCase
import gunixun.github.utils.CallbackData


class ProfilesDataSource(
    private val api: IGitHubApi
) : ProfilesUseCase {

    override fun getProfiles(
        callback: CallbackData<Profiles>
    ) {
        Thread {
            try {
                callback.onSuccess(
                    api.getProfiles()
                )
            } catch (exc: Exception) {
                callback.onError(exc)
            }
        }.start()
    }
}