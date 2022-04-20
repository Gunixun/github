package gunixun.github.ui.profiles

import androidx.recyclerview.widget.DiffUtil
import gunixun.github.domain.entities.Profile
import gunixun.github.utils.Change

class DiffUtilsCallback (
    private val newItems: List<Profile>,
    private val oldItems: List<Profile>
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
                && oldItem.login == newItem.login
                && oldItem.email == newItem.email
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return Change(oldItem, newItem)
    }

}