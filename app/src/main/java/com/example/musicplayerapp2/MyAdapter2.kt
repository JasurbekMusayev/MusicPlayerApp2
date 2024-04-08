import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayerapp2.MyKotlinModel2
import com.example.musicplayerapp2.databinding.ItemMusicPlayer2Binding

class MyAdapter2 : RecyclerView.Adapter<MyAdapter2.MyViewHolder>() {

    private val list2: ArrayList<MyKotlinModel2> = ArrayList<MyKotlinModel2>()

    fun setList(list: List<MyKotlinModel2>) {
        this.list2.clear()
        this.list2.addAll(list)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(var ItemMusicPlayer2Binding: ItemMusicPlayer2Binding) :
        RecyclerView.ViewHolder(ItemMusicPlayer2Binding.root) {
        fun onBind(model: MyKotlinModel2) {
            ItemMusicPlayer2Binding.man2.setImageResource(model.image)
            ItemMusicPlayer2Binding.title.text = model.tittle
            ItemMusicPlayer2Binding.artistName
                .text = model.artistname
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemMusicPlayer2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list2[position])
    }

    override fun getItemCount(): Int {
        return list2.size
    }
}