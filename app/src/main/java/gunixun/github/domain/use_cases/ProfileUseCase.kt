package gunixun.github.domain.use_cases

import gunixun.github.domain.entities.Profile
import gunixun.github.utils.CallbackData


interface ProfileUseCase {
    fun getProfile(
        login: String,
        callback: CallbackData<Profile>
    )
}