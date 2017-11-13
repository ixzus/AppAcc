package com.example.ixzus.acc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (null == savedInstanceState) {
            val fragment = ListFragment.newInstance("", "")

            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment, ListFragment.TAG)
                    .commit()
        }
    }

//    public void show(Product product) {
//
//        ProductFragment productFragment = ProductFragment.forProduct(product.getId());
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .addToBackStack("product")
//                .replace(R.id.fragment_container,
//                        productFragment, null).commit();
//    }
}
