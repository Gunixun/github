package gunixun.github.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import gunixun.github.data.use_cases.ProfilesDataSource
import gunixun.github.data.use_cases.ReposDataSource
import gunixun.github.data.web.github.GitHubApi
import gunixun.github.data.web.github.GitHubProjectRepoImpl
import gunixun.github.domain.ProjectRepo
import gunixun.github.domain.use_cases.ProfilesUseCase
import gunixun.github.domain.use_cases.ReposUseCase
import gunixun.github.ui.profiles.ProfilesViewModelFactory
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
class AppDependenciesModule(val context: Context) {

    @Provides
    @Named("api_url")
    fun provideBaseUrl(): String {
        return "https://api.github.com/"
    }

    @Singleton
    @Provides
    fun provideGitHubApi(retrofit: Retrofit): GitHubApi {
        return retrofit.create(GitHubApi::class.java)
    }

    @Singleton
    @Provides
    fun provideProjectRepo(api: GitHubApi): ProjectRepo {
        return GitHubProjectRepoImpl(api)
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(@Named("api_url") baseUrl: String, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(converterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideReposUseCase(api: ProjectRepo): ReposUseCase {
        return ReposDataSource(api)
    }

    @Singleton
    @Provides
    fun provideProfilesUseCase(api: ProjectRepo): ProfilesUseCase {
        return ProfilesDataSource(api)
    }
}