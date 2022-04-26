package gunixun.github.di

import gunixun.github.data.use_cases.ProfilesDataSource
import gunixun.github.data.use_cases.ReposDataSource
import gunixun.github.data.web.github.GitHubApi
import gunixun.github.data.web.github.GitHubProjectRepoImpl
import gunixun.github.domain.ProjectRepo
import gunixun.github.domain.use_cases.ProfilesUseCase
import gunixun.github.domain.use_cases.ReposUseCase
import gunixun.github.ui.profile_details.ReposViewModel
import gunixun.github.ui.profile_details.ReposViewModelAbs
import gunixun.github.ui.profiles.ProfilesViewModel
import gunixun.github.ui.profiles.ProfilesViewModelAbs
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<String>(named("api_url")) { "https://api.github.com/" }

    single {
        Retrofit.Builder()
            .baseUrl(get<String>(named("api_url")))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(get())
            .build()
    }

    single<GitHubApi> { get<Retrofit>().create(GitHubApi::class.java) }

    single<ProjectRepo> { GitHubProjectRepoImpl(get()) }

    single<ProfilesUseCase> { ProfilesDataSource(get()) }

    single<ReposUseCase> { ReposDataSource(get()) }

    factory<Converter.Factory> { GsonConverterFactory.create() }

    viewModel<ProfilesViewModelAbs> { ProfilesViewModel(get()) }
    viewModel<ReposViewModelAbs> { ReposViewModel(get()) }
}
