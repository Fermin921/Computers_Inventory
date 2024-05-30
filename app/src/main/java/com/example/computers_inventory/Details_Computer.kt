package com.example.computers_inventory
import com.example.computers_inventory.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Details_Computer: AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.details_computer)
        tabLayout = findViewById(R.id.Tabs)
        viewPager = findViewById(R.id.viewPager)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.divCard)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Inicializar el FragmentManager
        val fragmentManager = supportFragmentManager

        // Comenzar una transacción de fragmento
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Crear una instancia del fragmento
        val alertDeleteFragment = Alert_Delete()

        // Reemplazar el contenido del contenedor con el fragmento
        fragmentTransaction.replace(R.id.fragment_container, alertDeleteFragment)

        // Confirmar la transacción
        fragmentTransaction.commit()
        // Configurar el botón de eliminar para traer al frente el FrameLayout
        val btnDelete: Button = findViewById(R.id.btnDelete)
        btnDelete.setOnClickListener {
            val fragmentContainer: FrameLayout = findViewById(R.id.fragment_container)
            fragmentContainer.bringToFront()
            fragmentContainer.visibility = View.VISIBLE
        }
    }
    fun restoreFragmentContainer() {
        val fragmentContainer: FrameLayout = findViewById(R.id.fragment_container)
        fragmentContainer.visibility = View.GONE
    }
}