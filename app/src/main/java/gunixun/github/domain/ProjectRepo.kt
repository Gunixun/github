package gunixun.github.domain

import gunixun.github.domain.entities.Profile
import gunixun.github.domain.entities.Repo
import io.reactivex.rxjava3.core.Single

interface ProjectRepo {

    fun getProfiles() : Single<List<Profile>>

    fun getRepos(loginProfile: String) : Single<List<Repo>>
}