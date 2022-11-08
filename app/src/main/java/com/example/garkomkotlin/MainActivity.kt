package com.example.garkomkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import com.example.garkomkotlin.databinding.ActivityMainBinding
import com.example.garkomkotlin.fragments.*
import com.google.android.material.appbar.AppBarLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_container,anaSayfaFragment()).commit()

        binding.btnHakkimizda.setOnClickListener {
            val hakkimizdaTransaction = supportFragmentManager.beginTransaction()
            hakkimizdaTransaction.replace(R.id.main_container,hakkimizdaFragment()).commit()
        }
        binding.logo.setOnClickListener {
            val anasayfaTransaction = supportFragmentManager.beginTransaction()
            anasayfaTransaction.replace(R.id.main_container,anaSayfaFragment()).commit()
        }
        setSupportActionBar(binding.toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fragment_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.ana_sayfa){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.main_container,anaSayfaFragment()).commit()
        }else if (item.itemId == R.id.garkom_nasil_calisir){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.main_container,garkomNasilCalisir()).commit()
        }else if (item.itemId == R.id.isAriyorum){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.main_container,isAriyorumFragment()).commit()
        }else if (item.itemId == R.id.calisanAriyorum){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.main_container,calisanAriyorumFragment()).commit()
        }else if (item.itemId == R.id.hakkimizda){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.main_container,hakkimizdaFragment()).commit()
        }else if(item.itemId == R.id.garkom_turizm){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.main_container,turizmFragment()).commit()
        }
        return super.onOptionsItemSelected(item)
    }



    class CollapsibleToolbar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
    ) : MotionLayout(context, attrs, defStyleAttr), AppBarLayout.OnOffsetChangedListener {

        override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
            progress = -verticalOffset / appBarLayout?.totalScrollRange?.toFloat()!!
        }

        override fun onAttachedToWindow() {
            super.onAttachedToWindow()
            (parent as? AppBarLayout)?.addOnOffsetChangedListener(this)
        }
    }
}