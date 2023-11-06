package com.kdn.stack_knowledge_android.adapter.mission

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kdn.domain.entity.mission.MissionEntity
import com.kdn.stack_knowledge_android.databinding.ItemShadowedMissionBinding

class MissionPageMissionListAdapter :
    ListAdapter<MissionEntity, MissionPageMissionListAdapter.MissionListViewHolder>(diffUtil){
    private lateinit var itemClickListener: OnItemClickListener

    inner class MissionListViewHolder(
            val context: Context,
            private val binding: ItemShadowedMissionBinding,
            private val listener: OnItemClickListener,
        ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: MissionEntity) = binding.apply {
                tvTeacherName.text = item.user.name
                tvTitle.text = item.title
                tvMileage.text = item.point.toString()
                shadowedMissionItemLayout.setOnClickListener {
                    listener.detail(item)
                }
            }
        }

    interface OnItemClickListener {
        fun detail(item: MissionEntity)
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

    fun setItemOnClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MissionListViewHolder =
        MissionListViewHolder(
            parent.context,
            ItemShadowedMissionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            itemClickListener
        )

    override fun onBindViewHolder(holder: MissionListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}