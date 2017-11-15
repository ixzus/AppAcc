package com.example.ixzus.acc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ixzus.acc.data.db.entity.Product

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (null == savedInstanceState) {
            val fragment = ProductListFragment.newInstance("", "")

            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment, ProductListFragment.TAG)
                    .commit()
        }
    }

    fun show(product: Product) {

        val productFragment = ProductlFragment.newInstance(product._id, "")

        supportFragmentManager
                .beginTransaction()
                .addToBackStack("product")
                .replace(R.id.fragment_container,
                        productFragment, null).commit()
    }

}
