package com.example.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.wikipedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.ToolbarMain)

        val actionbardrawertoggle = ActionBarDrawerToggle(
            this,
            binding.DrawerLayoutMain,
            binding.ToolbarMain,
            R.string.openDrawer,
            R.string.closeDrawer
        )
        binding.DrawerLayoutMain.addDrawerListener(actionbardrawertoggle)
        actionbardrawertoggle.syncState()
        binding.NavigationViewMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_openwikipedia -> {

                    binding.DrawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_photograph -> {

                    binding.DrawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_videomaker -> {

                    binding.DrawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_translator -> {

                    binding.DrawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_writer -> {

                    binding.DrawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_visitwikipedia -> {

                    binding.DrawerLayoutMain.closeDrawer(GravityCompat.START)
                }
            }
            true
        }
    }
}