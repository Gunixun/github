package gunixun.github.data.web.github


import gunixun.github.data.web.github.dto.ProfileDto
import gunixun.github.data.web.github.dto.RepoDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubApi {

    @GET("users")
    fun getProfiles(): Single<List<ProfileDto>>

    @GET("users/{username}/repos")
    fun getRepos(
        @Path("username") username: String
    ): Single<List<RepoDto>>
}