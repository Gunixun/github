package gunixun.github.data.use_cases

import gunixun.github.domain.ProjectRepo
import gunixun.github.domain.entities.Profile
import gunixun.github.domain.use_cases.ProfilesUseCase
import io.reactivex.rxjava3.core.Single


class ProfilesDataSource(
    private val api: ProjectRepo
) : ProfilesUseCase {

    override fun getProfiles(): Single<List<Profile>> {
        return api.getProfiles()
    }
}