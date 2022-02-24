package com.example.foodcookbook.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodcookbook.databinding.ActivityMainBinding
import com.example.foodcookbook.models.RecipeBook
import com.example.foodcookbook.models.RecipeBookResult
import com.example.foodcookbook.viewmodel.RecipeBookViewModel
import com.example.foodcookbook.views.adapter.RecipeBookAdapter
import com.example.foodcookbook.views.component.RecipeBookDetBottomSheet
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    private  val viewModelRecipeBook: RecipeBookViewModel by viewModels()

    private val listRecipeBookObserver = Observer<RecipeBookResult> { recipeBookResult ->
        if (recipeBookResult.sussess) {
            recipeBookResult.list?.let {
                val adapter = RecipeBookAdapter(
                    it,
                    onItemClickListener,
                    applicationContext
                )
                binding?.recyclerview?.adapter = adapter
                adapter.notifyDataSetChanged()

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding?.root)
        initRecycler()
        initObserver()
        viewModelRecipeBook.getRecipebook()
        //getRecipebook()
    }

    private  var onItemClickListener: ((recipeBook:RecipeBook)-> Unit) = { product ->

        // meter aqui el response redirect para el fragment
        Toast.makeText(this, "Product: " + product.nameRecipebook,Toast.LENGTH_SHORT).show()

        RecipeBookDetBottomSheet.newInstance(product.nameRecipebook,product.productPhoto, product.recipeBook)
            .show(supportFragmentManager,"")
    }



    private fun initObserver() {
        viewModelRecipeBook.listRecipeBooks.observe(this, listRecipeBookObserver)
        //viewModelProduct.listProducts.observe(this,listProductObserver)
    }

    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding?.recyclerview?.apply {
            layoutManager = linearLayoutManager
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
            // itemAnimator = DefaultItemAnimator()
        }
    }

}