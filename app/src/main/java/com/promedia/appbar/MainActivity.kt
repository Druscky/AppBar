package com.promedia.appbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object{
        val ID_MENU1 = Menu.FIRST
        val ID_MENU2 = Menu.FIRST+1
        val ID_MENU3 = Menu.FIRST+2
    }
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
        menu.add(Menu.NONE, ID_MENU1, Menu.NONE, "Copiar")
        menu.add(Menu.NONE, ID_MENU2, Menu.NONE, "Refrescar")
        menu.add(Menu.NONE, ID_MENU3, Menu.NONE, "Buscar" )

        menuInflater.inflate(R.menu.mainmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            ID_MENU1 -> {
                val myIntentCopiar = Intent(this, ResultadoCopiar::class.java)
                myIntentCopiar.putExtra("INTENT_COPIAR", ID_MENU1)
                startActivity(myIntentCopiar)
            }
            ID_MENU2 ->{
                val myIntentRefrescar = Intent(this, ResultadoRefrescar::class.java)
                myIntentRefrescar.putExtra("INTENT_REFRESCAR", ID_MENU2)
                startActivity(myIntentRefrescar)
            }
            ID_MENU3 -> {
                val myIntentBuscar = Intent(this, ResultadoBuscar::class.java)
                myIntentBuscar.putExtra("INTENT_BUSCAR", ID_MENU3)
                startActivity(myIntentBuscar)
            }
            R.id.meSeleccionar ->{
                Toast.makeText(this, "Buscando...", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.mePegar ->{
                Toast.makeText(this, "Refrescando...", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.meCopiar ->{
                Toast.makeText(this, "Copiando...", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false


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
