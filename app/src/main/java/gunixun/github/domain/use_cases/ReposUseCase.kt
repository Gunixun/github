package gunixun.github.domain.use_cases

import gunixun.github.domain.entities.Repo
import gunixun.github.utils.CallbackData

interface ReposUseCase {
    fun getRepos(
        loginProfile: String,
        callback: CallbackData<List<Repo>>
    )
}