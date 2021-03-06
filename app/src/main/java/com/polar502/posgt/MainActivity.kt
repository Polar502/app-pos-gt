package com.polar502.posgt

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.polar502.posgt.databinding.ActivityMainBinding
import com.polar502.posgt.customers.CustomersFragment
import com.polar502.posgt.home.HomeFragment
import com.polar502.posgt.inventory.InventoryFragment
import com.polar502.posgt.providers.ProvidersFragment


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            //Recupero los posibles parametros de entrada
            val bundle = intent.extras
            val estado = bundle?.getString("estado")

            //Decido cual de los dos Fregments iniciar segun los parametros iniciales de MainActivity
            if(estado == "inventario"){

                //Se inicia por defecto la vista en el fragmento de Inventory
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentcontainerview, InventoryFragment())
                    commit()}

            } else{

                //Se inicia por defecto la vista en el fragmento de Home
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentcontainerview, HomeFragment())
                    commit()}

            }

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_home -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragmentcontainerview, HomeFragment())
                            commit()
                        }
                    }
                    R.id.nav_inventory -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragmentcontainerview, InventoryFragment())
                            commit()
                        }
                    }
                    R.id.nav_providers -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragmentcontainerview, ProvidersFragment())
                            commit()
                        }
                    }
                    R.id.nav_customers -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragmentcontainerview, CustomersFragment())
                            commit()
                        }
                    }
                }
                drawerLayout.closeDrawer(GravityCompat.START)
                true
            }

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }
}