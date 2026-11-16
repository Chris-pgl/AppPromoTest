package com.example.myapplication

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var planetArrayList: ArrayList<Planet>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1- AdapterView: a ListView
         listView = findViewById(R.id.listview)

        //2- Data Souce: ArrayList<Planet>
        planetArrayList = ArrayList()

        //3 Adding items to the list
        planetArrayList.add(Planet("Earth", "1 Moon", R.drawable.earth))
        planetArrayList.add(Planet("Mars", "2 Moons", R.drawable.mars))
        planetArrayList.add(Planet("Jupiter", "79 Moons", R.drawable.jupiter))
        planetArrayList.add(Planet("Saturn", "82 Moons", R.drawable.saturn))
        planetArrayList.add(Planet("Uranus", "27 Moons", R.drawable.uranus))
        planetArrayList.add(Planet("Neptune", "14 Moons", R.drawable.neptune))
        planetArrayList.add(Planet("Mercury", "0 Moons", R.drawable.mercury))
        planetArrayList.add(Planet("Venus", "0 Moons", R.drawable.venus))
        planetArrayList.add(Planet("Pluto", "5 Moons", R.drawable.pluto))

        // 4- Create CustomAdapter
        val customAdapter = CustomAdapter(planetArrayList, this)

        // 5 - Connect Adapter to ListView
        listView.adapter = customAdapter

    }
}