package com.kdn.stack_knowledge_android.adapter.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.ItemMainBannerBinding

val bannerList = listOf(R.drawable.first_bannner, R.drawable.second_banner, R.drawable.third_banner)

class MainViewPagerAdapter(private val context: Context) :
    RecyclerView.Adapter<MainViewPagerAdapter.MainViewPagerViewHolder>() {
    class MainViewPagerViewHolder(val binding: ItemMainBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, position: Int) {
            Glide.with(context).load(bannerList[position]).into(binding.ivBanner)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewPagerViewHolder {
        val binding =
            ItemMainBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MainViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewPagerViewHolder, position: Int) {
        holder.bind(context, position)
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }

}