package gunixun.github.domain

import gunixun.github.domain.entities.Profile
import gunixun.github.domain.entities.Profiles
import gunixun.github.domain.entities.Repos

interface IGitHubApi {

    fun getProfiles() : Profiles

    fun getProfile(login: String) : Profile

    fun getRepos(loginProfile: String) : Repos
}