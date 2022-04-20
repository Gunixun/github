package gunixun.github.domain

import gunixun.github.domain.entities.Profile
import gunixun.github.domain.entities.Repo

interface IGitHubApi {

    fun getProfiles() : List<Profile>

    fun getProfile(login: String) : Profile

    fun getRepos(loginProfile: String) : List<Repo>
}