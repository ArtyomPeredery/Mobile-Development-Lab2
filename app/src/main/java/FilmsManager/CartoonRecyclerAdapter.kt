package com.bsuir.FilmsManager


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_cartoon_item.view.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bsuir.FilmsManager.models.Cartoon
import com.bsuir.cartooons.R
import kotlin.collections.ArrayList


class CartoonRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private val TAG: String = "AppDebug"

    private var items: List<Cartoon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_cartoon_item, parent, false)

        view.setOnClickListener { view : View ->
            run {
                this.OnViewVideo(view)
            }
        };

        return CartoonViewHolder(
            view
        )
    }

    var itemClickListener : View.OnClickListener? = null

    fun OnViewVideo(view: View){
        itemClickListener?.onClick(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is CartoonViewHolder -> {
                holder.bind(items.get(position))
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(onClickListener: View.OnClickListener, cartoonList: List<Cartoon>){
        items = cartoonList
        itemClickListener = onClickListener
    }

    class CartoonViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val imageView = itemView.cartoon_image
        val nameView = itemView.cartoon_name
        val author_view = itemView.cartoon_studio
        val duration_view = itemView.cartoon_duration
        val rating_view = itemView.cartoon_rating;

        fun bind(cartoon: Cartoon){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(cartoon.thumbnailLink)
                .into(imageView)

            nameView.setText(cartoon.name)
            author_view.setText(cartoon.author)

            var hours = cartoon.durationSeconds / 60 / 60;
            var minutes = (cartoon.durationSeconds - hours * 60 * 60) / 60

            duration_view.setText("$hours " + itemView.context.resources.getString(R.string.filter_hours) + " " + "$minutes " +
                    itemView.context.resources.getString(R.string.filter_minutes));


            rating_view.setText(itemView.context.resources.getString(R.string.cartoonsview_rating) + ":" + String.format("%.2f", cartoon.rating))
        }

    }

}
