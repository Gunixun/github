package gunixun.github

import android.app.Application
import android.content.Context
import gunixun.github.data.InMemoryGitHubApi
import gunixun.github.data.use_cases.ProfileDataSource
import gunixun.github.data.use_cases.ProfilesDataSource
import gunixun.github.data.use_cases.ReposDataSource
import gunixun.github.domain.IGitHubApi
import gunixun.github.domain.use_cases.ProfileUseCase
import gunixun.github.domain.use_cases.ProfilesUseCase
import gunixun.github.domain.use_cases.ReposUseCase

class App : Application() {
    private val gitHubApi: IGitHubApi by lazy { InMemoryGitHubApi() }

    val profilesDataSource: ProfilesUseCase by lazy {
        ProfilesDataSource(app.gitHubApi)
    }
    val profileDataSource: ProfileUseCase by lazy {
        ProfileDataSource(app.gitHubApi)
    }
    val reposDataSource: ReposUseCase by lazy {
        ReposDataSource(app.gitHubApi)
    }
}

val Context.app: App
    get() = this.applicationContext as App