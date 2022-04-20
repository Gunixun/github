package gunixun.github.ui.utils

import gunixun.github.domain.entities.Profile
import gunixun.github.domain.entities.Repo

sealed class AppState {
    data class SuccessProfiles(val profile: List<Profile>) : AppState()
    data class SuccessProfile(val profile: Profile) : AppState()
    data class SuccessRepos(val profile: List<Repo>) : AppState()
    data class Error(val error: Exception) : AppState()
    object Loading : AppState()
}