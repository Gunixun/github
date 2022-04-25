package gunixun.github.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Profile(
    val id: Int,
    val login: String,
    val name: String?,
    val avatarUrl: String,
    val email: String?
): Parcelable


