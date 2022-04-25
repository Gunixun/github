package gunixun.github

import android.app.Application
import android.content.Context
import gunixun.github.data.use_cases.ProfilesDataSource
import gunixun.github.data.use_cases.ReposDataSource
import gunixun.github.data.web.github.GitHubProjectRepoImpl
import gunixun.github.domain.ProjectRepo
import gunixun.github.domain.use_cases.ProfilesUseCase
import gunixun.github.domain.use_cases.ReposUseCase

class App : Application() {
    private val gitHubApi: ProjectRepo by lazy { GitHubProjectRepoImpl() }

    val profilesDataSource: ProfilesUseCase by lazy {
        ProfilesDataSource(app.gitHubApi)
    }
    val reposDataSource: ReposUseCase by lazy {
        ReposDataSource(app.gitHubApi)
    }
}

val Context.app: App
    get() = this.applicationContext as App