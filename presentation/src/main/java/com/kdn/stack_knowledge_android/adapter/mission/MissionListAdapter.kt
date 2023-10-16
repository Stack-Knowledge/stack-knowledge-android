package com.kdn.stack_knowledge_android.adapter.mission

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kdn.domain.entity.MissionEntity
import com.kdn.stack_knowledge_android.databinding.ItemMissionBinding

class MissionListAdapter :
    ListAdapter<MissionEntity, MissionListAdapter.MissionListViewHolder>(diffUtil) {
    inner class MissionListViewHolder(
        val context: Context,
        private val binding: ItemMissionBinding,
        ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: MissionEntity) = binding.apply {
                tvTeacherName.text = item.id.toString()
                tvTitle.text = item.title
                tvMileage.text = item.point.toString()
            }
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MissionListViewHolder = MissionListViewHolder(
        parent.context,
        ItemMissionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: MissionListViewHolder, position: Int) {
        holder.bind(getItem(position))
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