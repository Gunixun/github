package gunixun.github.data

import gunixun.github.domain.IGitHubApi
import gunixun.github.domain.entities.Profile
import gunixun.github.domain.entities.Repo

class InMemoryGitHubApi: IGitHubApi {

    private val repoList: List<Repo> = listOf(
        Repo(id = 480469417, name="mvp_mvvm", full_name="Gunixun/mvp_mvvm", html_url= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", full_name="Gunixun/mvp_mvvm", html_url= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", full_name="Gunixun/mvp_mvvm", html_url= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", full_name="Gunixun/mvp_mvvm", html_url= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", full_name="Gunixun/mvp_mvvm", html_url= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", full_name="Gunixun/mvp_mvvm", html_url= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", full_name="Gunixun/mvp_mvvm", html_url= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", full_name="Gunixun/mvp_mvvm", html_url= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", full_name="Gunixun/mvp_mvvm", html_url= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin"),
        Repo(id = 480469417, name="mvp_mvvm", full_name="Gunixun/mvp_mvvm", html_url= "https://github.com/Gunixun/mvp_mvvm", description=null, language = "Kotlin")

    )

    private val profiles: List<Profile> = listOf(
        Profile(id=89738580, login = "Gunixun", name=null, avatar_url="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=89738580, login = "Gunixun", name=null, avatar_url="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=89738580, login = "Gunixun", name=null, avatar_url="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=89738580, login = "Gunixun", name=null, avatar_url="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=89738580, login = "Gunixun", name=null, avatar_url="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=89738580, login = "Gunixun", name=null, avatar_url="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=89738580, login = "Gunixun", name=null, avatar_url="https://avatars.githubusercontent.com/u/89738580?v=4", email = null),
        Profile(id=71352, login = "uentity", name="Alexander Gagarin", avatar_url="https://avatars.githubusercontent.com/u/71352?v=4", email = null),
        Profile(id=71352, login = "uentity", name="Alexander Gagarin", avatar_url="https://avatars.githubusercontent.com/u/71352?v=4", email = null),
        Profile(id=71352, login = "uentity", name="Alexander Gagarin", avatar_url="https://avatars.githubusercontent.com/u/71352?v=4", email = null),
        Profile(id=71352, login = "uentity", name="Alexander Gagarin", avatar_url="https://avatars.githubusercontent.com/u/71352?v=4", email = null),
        Profile(id=71352, login = "uentity", name="Alexander Gagarin", avatar_url="https://avatars.githubusercontent.com/u/71352?v=4", email = null),
        Profile(id=71352, login = "uentity", name="Alexander Gagarin", avatar_url="https://avatars.githubusercontent.com/u/71352?v=4", email = null),
        Profile(id=71352, login = "octocat", name="The Octocat", avatar_url="https://avatars.githubusercontent.com/u/583231?v=4", email = null),
        Profile(id=71352, login = "octocat", name="The Octocat", avatar_url="https://avatars.githubusercontent.com/u/583231?v=4", email = null),
        Profile(id=71352, login = "octocat", name="The Octocat", avatar_url="https://avatars.githubusercontent.com/u/583231?v=4", email = null),
        Profile(id=71352, login = "octocat", name="The Octocat", avatar_url="https://avatars.githubusercontent.com/u/583231?v=4", email = null),
        Profile(id=71352, login = "octocat", name="The Octocat", avatar_url="https://avatars.githubusercontent.com/u/583231?v=4", email = null),

    )

    override fun getProfiles(): List<Profile> {
        Thread.sleep(2_000)
        return profiles
    }

    override fun getProfile(login: String): Profile {
        Thread.sleep(2_000)
        for (profile in profiles){
            if (profile.login == login){
                return profile
            }
        }
        throw Exception()
    }

    override fun getRepos(loginProfile: String): List<Repo> {
        Thread.sleep(2_000)
        return repoList
    }
}