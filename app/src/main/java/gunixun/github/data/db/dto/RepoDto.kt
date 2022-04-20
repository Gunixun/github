package gunixun.github.data.db.dto

data class RepoDto (
    val id: String,
    val name: String,
    val full_name: String,
    val html_url: String,
    val description: String?,
    val language: String?
)