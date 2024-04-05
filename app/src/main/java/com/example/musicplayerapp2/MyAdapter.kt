

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayerapp2.MyKotlinModel
import com.example.musicplayerapp2.databinding.ItemMusicPlayerBinding

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val list: ArrayList<MyKotlinModel> = ArrayList<MyKotlinModel>()

    fun setList(list: List<MyKotlinModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(var itemContactBinding: ItemMusicPlayerBinding) :
        RecyclerView.ViewHolder(itemContactBinding.root) {
        fun onBind(model: MyKotlinModel) {
            itemContactBinding.man2.setImageResource(model.image)
//            itemContactBinding.name.text = model.name
//            itemContactBinding.artistname
//                .text = model.artistname
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemMusicPlayerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}