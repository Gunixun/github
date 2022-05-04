package gunixun.github.di

import dagger.Component
import gunixun.github.ui.profile_details.ProfileDetailsFragment
import gunixun.github.ui.profiles.ProfilesFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppDependenciesModule::class
    ]
)
interface AppDependenciesComponent {
    fun inject(profilesFragment: ProfilesFragment)
    fun inject(reposFragment: ProfileDetailsFragment)
}