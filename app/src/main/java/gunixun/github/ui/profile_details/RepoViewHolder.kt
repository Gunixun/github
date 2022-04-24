package gunixun.github.ui.profile_details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gunixun.github.databinding.FragmentRepoItemBinding
import gunixun.github.domain.entities.Repo

class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun createView(parent: ViewGroup): RepoViewHolder {
            val binding = FragmentRepoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return RepoViewHolder(binding.root)
        }
    }

    fun bind(data: Repo) {
        FragmentRepoItemBinding.bind(itemView).apply {
            titleRepoTextView.text = data.name
            data.description?.let { descriptionTextView.text = it }
        }
    }
}