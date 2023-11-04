package com.kdn.stack_knowledge_android.adapter.score

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kdn.domain.entity.user.GetSolveMissionEntity
import com.kdn.stack_knowledge_android.databinding.ItemShadowedMissionBinding

class SolvedMissionListAdapter :
    ListAdapter<GetSolveMissionEntity, SolvedMissionListAdapter.SolvedMissionListViewHolder>(diffUtil) {
    private lateinit var itemClickListener: OnItemClickListener

    inner class SolvedMissionListViewHolder(
        val context: Context,
        private val binding: ItemShadowedMissionBinding,
        private val listener: OnItemClickListener,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GetSolveMissionEntity) = binding.apply {
            tvTeacherName.text = item.user.name
            tvTitle.text = item.title
            tvMileage.text = item.point.toString()
            shadowedMissionItemLayout.setOnClickListener {
                listener.detail(item)
            }
        }

    }

    interface OnItemClickListener {
        fun detail(item: GetSolveMissionEntity)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SolvedMissionListViewHolder =
        SolvedMissionListViewHolder(
            parent.context,
            ItemShadowedMissionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            itemClickListener
        )

    override fun onBindViewHolder(holder: SolvedMissionListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setItemOnClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<GetSolveMissionEntity>() {
            override fun areItemsTheSame(
                oldItem: GetSolveMissionEntity,
                newItem: GetSolveMissionEntity,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: GetSolveMissionEntity,
                newItem: GetSolveMissionEntity,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}