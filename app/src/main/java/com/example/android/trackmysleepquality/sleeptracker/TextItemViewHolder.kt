package com.example.android.trackmysleepquality.sleeptracker

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R

class TextItemViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val textView1:TextView = view.findViewById(R.id.textView1)

}

//class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
//    val iconIV: ImageView = view.findViewById(R.id.iconIV)
//    val titleTV: TextView = view.findViewById(R.id.titleTV)
//    val subtitleTV: TextView = view.findViewById(R.id.subtitleTV)
//}