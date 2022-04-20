package gunixun.github.domain.use_cases

import gunixun.github.domain.entities.Repos
import gunixun.github.utils.CallbackData

internal interface ReposUseCase {
    fun getRepos(
        loginProfile: String,
        callback: CallbackData<Repos>
    )
}