package gu.mvp_mvvm.utils

import gunixun.github.data.web.github.dto.ProfileDto
import gunixun.github.data.web.github.dto.RepoDto
import gunixun.github.domain.entities.Profile
import gunixun.github.domain.entities.Repo

fun convertProfilesDtoToEntity(profilesList: List<ProfileDto>): List<Profile> {
    val res: MutableList<Profile> = mutableListOf()

    for (profile in profilesList) {
        res.add(
            Profile(
                id = profile.id,
                login = profile.login,
                name = profile.name,
                avatarUrl = profile.avatar_url,
                email = profile.email
            )
        )

    }
    return res
}

fun convertReposDtoToEntity(reposList: List<RepoDto>): List<Repo> {
    val res: MutableList<Repo> = mutableListOf()

    for (profile in reposList) {
        res.add(
            Repo(
                id = profile.id,
                name = profile.name,
                fullName = profile.full_name,
                htmlUrl = profile.html_url,
                description = profile.description,
                language = profile.language
            )
        )
    }
    return res
}