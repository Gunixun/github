package gunixun.github.domain.entities

data class Profile(
    val id: Int,
    val login: String,
    val name: String?,
    val avatar_url: String,
    val email: String?
)
