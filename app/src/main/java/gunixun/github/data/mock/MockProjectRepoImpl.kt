package gunixun.github.data.mock

import gunixun.github.domain.ProjectRepo
import gunixun.github.domain.entities.Profile
import gunixun.github.domain.entities.Repo
import io.reactivex.rxjava3.core.Single

class MockProjectRepoImpl: ProjectRepo {

    private val repoList: List<Repo> = listOf(
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description="fdgdfgfdgfdgdfg", language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description="fdgdfgfdgfdgdfg", language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description="fdgdfgfdgfdgdfg", language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description="fdgdfgfdgfdgdfg", language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description="fdgdfgfdgfdgdfg", language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description="fdgdfgfdgfdgdfg", language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description="fdgdfgfdgfdgdfg", language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description="fdgdfgfdgfdgdfg", language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", fullName="Gunixun/mvp_mvvm", htmlUrl= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin")

    )

    private val profiles: List<Profile> = listOf(
        Profile(id=89738580, login = "Gunixun", name=null, avatarUrl="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=89738580, login = "Gunixun", name=null, avatarUrl="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=89738580, login = "Gunixun", name=null, avatarUrl="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=89738580, login = "Gunixun", name=null, avatarUrl="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=89738580, login = "Gunixun", name=null, avatarUrl="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=89738580, login = "Gunixun", name=null, avatarUrl="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=89738580, login = "Gunixun", name=null, avatarUrl="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=71352, login = "uentity", name="Alexander Gagarin", avatarUrl="https://avatars.githubusercontent.com/u/71352?v=4", email = null),
        Profile(id=71352, login = "uentity", name="Alexander Gagarin", avatarUrl="https://avatars.githubusercontent.com/u/71352?v=4", email = null),
        Profile(id=71352, login = "uentity", name="Alexander Gagarin", avatarUrl="https://avatars.githubusercontent.com/u/71352?v=4", email = null),
        Profile(id=71352, login = "uentity", name="Alexander Gagarin", avatarUrl="https://avatars.githubusercontent.com/u/71352?v=4", email = null),
        Profile(id=71352, login = "uentity", name="Alexander Gagarin", avatarUrl="https://avatars.githubusercontent.com/u/71352?v=4", email = null),
        Profile(id=71352, login = "uentity", name="Alexander Gagarin", avatarUrl="https://avatars.githubusercontent.com/u/71352?v=4", email = null),
        Profile(id=71352, login = "octocat", name="The Octocat", avatarUrl="https://avatars.githubusercontent.com/u/583231?v=4", email = null),
        Profile(id=71352, login = "octocat", name="The Octocat", avatarUrl="https://avatars.githubusercontent.com/u/583231?v=4", email = null),
        Profile(id=71352, login = "octocat", name="The Octocat", avatarUrl="https://avatars.githubusercontent.com/u/583231?v=4", email = null),
        Profile(id=71352, login = "octocat", name="The Octocat", avatarUrl="https://avatars.githubusercontent.com/u/583231?v=4", email = null),
        Profile(id=71352, login = "octocat", name="The Octocat", avatarUrl="https://avatars.githubusercontent.com/u/583231?v=4", email = null),

    )

    override fun getProfiles(): Single<List<Profile>> {
        return Single.just(profiles)
    }

    override fun getRepos(loginProfile: String): Single<List<Repo>> {
        return Single.just(repoList)
    }
}