package gunixun.github.domain.entities

data class Repo(
    val id: Int,
    val name: String,
    val fullName: String,
    val htmlUrl: String,
    val description: String?,
    val language: String?
)
