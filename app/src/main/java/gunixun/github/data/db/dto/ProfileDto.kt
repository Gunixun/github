package gunixun.github.data.db.dto

data class ProfileDto (
    val id: Int,
    val name: String?,
    val avatar_url: String,
    val html_url: String,
    val email: String,
    val login: String
)