package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(
    private val planetsArrayList: ArrayList<Planet>,
    context: Context
) : ArrayAdapter<Planet>(
    context,
    R.layout.item_list_layout,
    planetsArrayList
) {


    private class ViewHolder(
        var planetName: TextView,
        var moonCount: TextView,
        var planetImage: ImageView
    )

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {


        // 1 - Get the planet object
        val planet = planetsArrayList[position]

        //2- Inflate Layout
        val rowView: View
        val myViewHolder: ViewHolder

        // 3 - Check if the view is reusable
        if (convertView == null) {

            /**
                Android chiama getView().
                convertView è null.
                Creiamo la riga tramite LayoutInflater.
                Creiamo il ViewHolder e cerchiamo le View con findViewById().
                Salviamo il ViewHolder in rowView.tag.
                Inseriamo i dati del pianeta nelle View.
                Restituiamo la riga.
             */

            // Inflate layout
            rowView = LayoutInflater.from(context).inflate(
                R.layout.item_list_layout,
                parent,
                false
            )

            // Create ViewHolder
            myViewHolder = ViewHolder(
                rowView.findViewById(R.id.planet_name),
                rowView.findViewById(R.id.moon_count),
                rowView.findViewById(R.id.imageView)
            )

            // Set Tag / Save ViewHolder
            rowView.tag = myViewHolder

        } else {
            /**
            Android chiama nuovamente getView().
            convertView non è null.
            Recuperiamo il ViewHolder da convertView.tag.
            Aggiorniamo i dati del nuovo pianeta.
            Restituiamo la View riutilizzata.
             */
            // Reuse existing view
            rowView = convertView
            myViewHolder = convertView.tag as ViewHolder
        }

        //Set Data
        myViewHolder.planetName.text = planet.name
        myViewHolder.moonCount.text = planet.moonCount
        myViewHolder.planetImage.setImageResource(planet.planetImage)

        // Return view
        return rowView
    }
}





