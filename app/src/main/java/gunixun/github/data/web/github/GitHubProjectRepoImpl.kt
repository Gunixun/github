package gunixun.github.data.web.github

import gu.mvp_mvvm.utils.convertProfilesDtoToEntity
import gu.mvp_mvvm.utils.convertReposDtoToEntity
import gunixun.github.domain.ProjectRepo
import gunixun.github.domain.entities.Profile
import gunixun.github.domain.entities.Repo
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GitHubProjectRepoImpl : ProjectRepo {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api: GitHubApi = retrofit.create(GitHubApi::class.java)

    override fun getProfiles(): Single<List<Profile>> {
        return api.getProfiles().map { convertProfilesDtoToEntity(it) }
    }

    override fun getRepos(loginProfile: String): Single<List<Repo>> {
        return api.getRepos(loginProfile).map { convertReposDtoToEntity(it) }
    }
}
