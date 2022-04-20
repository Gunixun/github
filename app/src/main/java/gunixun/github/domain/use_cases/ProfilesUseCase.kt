package gunixun.github.domain.use_cases

import gunixun.github.domain.entities.Profile
import gunixun.github.utils.CallbackData


interface ProfilesUseCase {
    fun getProfiles(
        callback: CallbackData<List<Profile>>
    )
}