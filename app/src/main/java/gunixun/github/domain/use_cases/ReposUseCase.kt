package gunixun.github.domain.use_cases

import gunixun.github.domain.entities.Repo
import io.reactivex.rxjava3.core.Single

interface ReposUseCase {
    fun getRepos(loginProfile: String): Single<List<Repo>>
}