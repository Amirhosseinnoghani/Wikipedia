package com.example.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragments.ExploreFragment
import com.example.wikipedia.fragments.ProfileFragment
import com.example.wikipedia.fragments.TrendFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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
        firstRun()
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
        binding.botoomNavMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_explore -> {
                    replaceFragment(ExploreFragment())
                }
                R.id.menu_trend -> {
                    replaceFragment(TrendFragment())
                }
                R.id.menu_profiler -> {
                    replaceFragment(ProfileFragment())
                }
            }
            true
        }
        binding.botoomNavMain.setOnItemReselectedListener {}
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()
    }

    private fun firstRun() {
        replaceFragment(ExploreFragment())
    }
}