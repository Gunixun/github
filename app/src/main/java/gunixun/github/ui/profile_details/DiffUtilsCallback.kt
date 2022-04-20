package gunixun.github.ui.profile_details

import androidx.recyclerview.widget.DiffUtil
import gunixun.github.domain.entities.Repo
import gunixun.github.utils.Change

class DiffUtilsCallback (
    private val newItems: List<Repo>,
    private val oldItems: List<Repo>
) :
    DiffUtil.Callback() {

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean {
        return newItems[newPos].id == oldItems[oldPos].id
    }

    override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean {
        val oldItem = oldItems[newPos]
        val newItem = newItems[newPos]
        return oldItem.name == newItem.name
                && oldItem.full_name == newItem.full_name
                && oldItem.html_url == newItem.html_url
                && oldItem.description == newItem.description
                && oldItem.language == newItem.language
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return Change(oldItem, newItem)
    }

}