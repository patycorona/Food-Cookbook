package com.example.foodcookbook.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.foodcookbook.R
import com.example.foodcookbook.models.RecipeBook


class RecipeBookAdapter(
    private val dataSource: MutableList<RecipeBook>,
    var onListHitItemClickListener: ((recipeBook: RecipeBook) -> Unit),
    val context: Context
): RecyclerView.Adapter<RecipeBookAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nameRecipebook: TextView = view.findViewById(R.id.tv_nombrePlatillo) as TextView
        var imgProduct : ImageView = view.findViewById(R.id.img_product) as ImageView
        var author: TextView = view.findViewById(R.id.tv_Author) as TextView
        var root: ConstraintLayout = view.findViewById(R.id.layout_item_recipebook) as ConstraintLayout
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context )
            .inflate(R.layout.item_recipebook , viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.nameRecipebook.text = dataSource[position].nameRecipebook
        viewHolder.author.text = dataSource[position].author
        //viewHolder.imgProduct.setImageDrawable(context.getDrawable(dataSource[position].productPhoto))

        Glide.with(context)
            //.load(context.getDrawable(dataSource[position].productPhoto))
            .load(dataSource[position].productPhoto)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .circleCrop()
            .into(viewHolder.imgProduct)

        viewHolder.root.setOnClickListener {
            onListHitItemClickListener.invoke(dataSource[position])
        }
    }

    override fun getItemCount() = dataSource.size

}