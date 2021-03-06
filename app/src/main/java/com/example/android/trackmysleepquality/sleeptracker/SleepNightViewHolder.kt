package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding

class SleepNightViewHolder private constructor(val binding: ListItemSleepNightBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(clickListener: SleepNightListener, item: SleepNight) {
        binding.sleep = item
        binding.clickListener = clickListener
        binding.executePendingBindings()
//        val res = itemView.context.resources
//
//        binding.sleepLength.text =
//            convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, res)
//        binding.qualityString.text = convertNumericQualityToString(item.sleepQuality, res)
//        binding.qualityImage.setImageResource(
//            when (item.sleepQuality) {
//                0 -> R.drawable.ic_sleep_0
//                1 -> R.drawable.ic_sleep_1
//                2 -> R.drawable.ic_sleep_2
//                3 -> R.drawable.ic_sleep_3
//                4 -> R.drawable.ic_sleep_4
//                5 -> R.drawable.ic_sleep_5
//                else -> R.drawable.ic_launcher_sleep_tracker_foreground
//            }
//        )
    }

    companion object {
        fun from(parent: ViewGroup): SleepNightViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemSleepNightBinding.inflate(layoutInflater, parent, false)

            return SleepNightViewHolder(binding)
        }
    }
}

class SleepNightDiffCallback : DiffUtil.ItemCallback<SleepNight>() {
    override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem.nightId == newItem.nightId
    }

    override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem == newItem
    }
}