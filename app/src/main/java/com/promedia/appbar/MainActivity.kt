package com.promedia.appbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.title = "Barra de Acciones"
        actionBar.subtitle = "Diseñando la barra"
        actionBar.setIcon(R.drawable.amongus)

        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        val vista = findViewById<TextView>(R.id.tvHelloWorld) as TextView
        registerForContextMenu(vista)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.meSeleccionar -> Toast.makeText(this, "Buscando...", Toast.LENGTH_SHORT).show()
            R.id.mePegar -> Toast.makeText(this, "Refrescando...", Toast.LENGTH_SHORT).show()
            R.id.meCopiar -> Toast.makeText(this, "Copiando...", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.tvHelloWorld) {
            menuInflater.inflate(R.menu.contextual_menu, menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        super.onContextItemSelected(item)
        when (item.itemId) {
            R.id.meCopiar -> Toast.makeText(this, "Copiar", Toast.LENGTH_SHORT).show()
            R.id.mePegar -> Toast.makeText(this, "Pegar", Toast.LENGTH_SHORT).show()
            R.id.meSeleccionar -> Toast.makeText(this, "Seleccionar todo", Toast.LENGTH_SHORT).show()
        }
        return false
    }

}
