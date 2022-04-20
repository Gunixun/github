package gunixun.github.domain.entities

data class Repo(
    val id: Int,
    val name: String,
    val full_name: String,
    val html_url: String,
    val description: String?,
    val language: String?
)
