package gunixun.github.data.use_cases

import gunixun.github.domain.ProjectRepo
import gunixun.github.domain.entities.Repo
import gunixun.github.domain.use_cases.ReposUseCase
import gunixun.github.utils.CallbackData
import io.reactivex.rxjava3.core.Single


class ReposDataSource(
    private val api: ProjectRepo
) : ReposUseCase {

    override fun getRepos(loginProfile: String): Single<List<Repo>> {
        return api.getRepos(loginProfile)
    }
}