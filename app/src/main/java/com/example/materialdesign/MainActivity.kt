package com.example.materialdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.materialdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Подгружаем боттом апп бар
        setSupportActionBar(binding?.bottomBarFAB)

        // назначаем тапа по бару в отдельном методе
        binding?.bottomBarFAB?.setOnMenuItemClickListener { menuItem -> itemSelected(menuItem)}

    }

    // Надуваем апп бар содержимым
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val menuInflater = menuInflater

        menuInflater.inflate(R.menu.bottom_menu, menu)

        return true

    }

    // Тапы по кнопкам бара
    private fun itemSelected(item: MenuItem):Boolean {

        when(item.itemId) {

            R.id.homeItemId ->  supportFragmentManager.beginTransaction().replace(R.id.content,
                Home()
            ).commit()

            R.id.shopItemId ->  supportFragmentManager.beginTransaction().replace(R.id.content,
                Shop()
            ).commit()

            R.id.deliveryItemId -> supportFragmentManager.beginTransaction().replace(R.id.content,
                Delivery()
            ).commit()

            R.id.accountItemId -> supportFragmentManager.beginTransaction().replace(R.id.content,
                Account()
            ).commit()
        }

        return true
    }


}