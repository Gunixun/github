package gunixun.github.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile(
    val id: Int,
    val login: String,
    val name: String?,
    val avatar_url: String,
    val email: String?
): Parcelable


