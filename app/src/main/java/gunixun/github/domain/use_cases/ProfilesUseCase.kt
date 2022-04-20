package gunixun.github.domain.use_cases

import gunixun.github.domain.entities.Profiles
import gunixun.github.utils.CallbackData


interface ProfilesUseCase {
    fun getProfiles(
        callback: CallbackData<Profiles>
    )
}