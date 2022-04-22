package com.android.challengeroneapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.android.challengeroneapp.R
import com.android.challengeroneapp.view.cart.CartFragment
import com.android.challengeroneapp.view.product.ProductFragment
import com.android.challengeroneapp.view.user.UserProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnItemSelectedListener(mOnNavigationListener)
        bottomNavigation.menu.setGroupCheckable(1, false, true)

        openFragment(firstFragment)
    }

    private val mOnNavigationListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.navigation_dashboard -> {
                openFragment(firstFragment)
                true
            }

            R.id.navigation_billUpload -> {
                openFragment(secondFragment)
                true
            }

            R.id.navigation_settings -> {
                openFragment(thirdFragment)
                true
            }
            else -> false
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    companion object {
        val firstFragment = ProductFragment()
        val secondFragment = CartFragment()
        val thirdFragment = UserProfileFragment()
    }
}