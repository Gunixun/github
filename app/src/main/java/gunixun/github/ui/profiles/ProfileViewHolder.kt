package gunixun.github.ui.profiles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import gunixun.github.databinding.FragmentProfileItemBinding
import gunixun.github.domain.entities.Profile

class ProfileViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun createView(parent: ViewGroup): ProfileViewHolder {
            val binding = FragmentProfileItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ProfileViewHolder(binding.root)
        }
    }

    fun bind(data: Profile, listener: (Profile) -> Unit) {
        FragmentProfileItemBinding.bind(itemView).apply {
            avatarImageView.load(data.avatarUrl)
            loginTextView.text = data.login
            nameTextView.text = data.name
            itemView.setOnClickListener {
                listener.invoke(data)
            }
        }
    }
}