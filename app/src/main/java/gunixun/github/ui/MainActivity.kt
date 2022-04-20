package gunixun.github.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import gunixun.github.R
import gunixun.github.databinding.ActivityMainBinding
import gunixun.github.ui.user_acconts.ProfilesFragment

class MainActivity : AppCompatActivity() {
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

    private fun navigationTo(fragment: Fragment, withTransaction: Boolean) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)

        if (withTransaction) {
            transaction.addToBackStack("Transaction")
        }

        transaction.commit()

    }

    private fun setHomePage() {
        navigationTo(ProfilesFragment.newInstance(), false)
    }

}