package gunixun.github.domain.use_cases

import gunixun.github.domain.entities.Profile
import io.reactivex.rxjava3.core.Single


interface ProfilesUseCase {
    fun getProfiles(): Single<List<Profile>>
}