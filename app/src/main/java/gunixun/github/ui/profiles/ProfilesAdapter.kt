package gunixun.github.ui.profiles

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import gunixun.github.databinding.FragmentProfileItemBinding
import gunixun.github.domain.entities.Profile
import gunixun.github.utils.Change
import gunixun.github.utils.createCombinePayloads

class ProfilesAdapter(
    private val itemClickCallback: (Profile) -> Unit
): RecyclerView.Adapter<ProfileViewHolder>() {

    private var listData: MutableList<Profile> = arrayListOf()

    fun setData(data: List<Profile>) {
        val diffResult = DiffUtil.calculateDiff(DiffUtilsCallback(listData, data))
        diffResult.dispatchUpdatesTo(this)
        listData.clear()
        listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileViewHolder.createView(parent)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(listData[position], itemClickCallback)
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(
        holder: ProfileViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()) {
            val change = createCombinePayloads(payloads as List<Change<Profile>>)
            val oldData = change.oldData
            val newData = change.newData

            if (oldData.name != newData.name){
                FragmentProfileItemBinding.bind(holder.itemView).nameTextView.text =
                    newData.name
            }

            if (oldData.login != newData.login){
                FragmentProfileItemBinding.bind(holder.itemView).loginTextView.text =
                    newData.login
            }

        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }
}