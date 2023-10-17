package com.kdn.stack_knowledge_android.adapter.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kdn.domain.entity.mission.MissionEntity
import com.kdn.stack_knowledge_android.databinding.ItemMissionBinding


class MissionListAdapter :
    ListAdapter<MissionEntity, MissionListAdapter.MissionListViewHolder>(diffUtil) {
    private lateinit var itemClickListener: OnItemClickListener

    inner class MissionListViewHolder(
        val context: Context,
        private val binding: ItemMissionBinding,
        val listener: OnItemClickListener,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MissionEntity?) = binding.apply {
            tvTeacherName.text = item?.user?.name
            tvTitle.text = item?.title
            tvMileage.text = item?.point.toString()
            missionItemLayout.setOnClickListener {
                listener.detail(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionListViewHolder =
        MissionListViewHolder(
            parent.context,
            ItemMissionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            itemClickListener
        )

    override fun onBindViewHolder(holder: MissionListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    interface OnItemClickListener {
        fun detail(item: MissionEntity?)
    }

    fun setItemOnClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<MissionEntity>() {
            override fun areItemsTheSame(
                oldItem: MissionEntity,
                newItem: MissionEntity,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: MissionEntity,
                newItem: MissionEntity,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}