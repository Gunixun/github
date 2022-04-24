package gunixun.github.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import gunixun.github.R
import gunixun.github.databinding.ActivityMainBinding
import gunixun.github.domain.entities.Profile
import gunixun.github.ui.profile_details.ProfileDetailsFragment
import gunixun.github.ui.profiles.ProfilesFragment

class MainActivity :
    AppCompatActivity(),
    ProfilesFragment.Controller
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            setHomePage()
        }
    }

    private fun navigationTo(fragment: Fragment, withTransaction: Boolean = false) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)

        if (withTransaction) {
            transaction.addToBackStack("Transaction")
        }

        transaction.commit()

    }

    private fun setHomePage() {
        navigationTo(ProfilesFragment.newInstance())
    }

    override fun openProfileDetailsScreen(profile: Profile) {
        navigationTo(ProfileDetailsFragment.newInstance(profile), true)
    }
}