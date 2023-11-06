package com.kdn.stack_knowledge_android.ui.ranking

import android.net.Uri
import android.util.Log
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.kdn.domain.entity.student.MyInfoEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.ranking.RankingPageRakingListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentRankingBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import com.kdn.stack_knowledge_android.utils.decorator.VerticalItemDecorator
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.utils.toFile
import com.kdn.stack_knowledge_android.viewmodel.ranking.MyInfoViewModel
import com.kdn.stack_knowledge_android.viewmodel.ranking.RankingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RankingFragment : BaseFragment<FragmentRankingBinding>(R.layout.fragment_ranking) {
    private val rankingViewModel by activityViewModels<RankingViewModel>()
    private val myInfoViewModel by activityViewModels<MyInfoViewModel>()
    private val pickMedia = registerForActivityResult(PickVisualMedia()) { uri ->
        if (uri != null) {
            myInfoViewModel.saveProfileImage(uri.toFile(requireContext()))
            myInfoViewModel.changeProfileImage(uri.toFile(requireContext()))
            Glide.with(binding.ivProfile).load(uri)
        }
    }
    private lateinit var rankingListAdapter: RankingPageRakingListAdapter

    override fun createView() {
        initRecyclerView()
        observeEvent()
        myInfoViewModel.getMyInfo()
    }

    override fun observeEvent() {
        repeatOnStart {
            rankingViewModel.eventFlow.collect { event -> observeRankingData(event) }
        }
        repeatOnStart {
            myInfoViewModel.eventFlow.collect { event -> observeMyInfoData(event) }
        }
    }

    private fun initRecyclerView() {
        rankingViewModel.getRankingList()
        rankingListAdapter = RankingPageRakingListAdapter()
        binding.rvRanking.adapter = rankingListAdapter
        binding.rvRanking.addItemDecoration(VerticalItemDecorator(8))
    }

    private fun initMyInfo(data: MyInfoEntity) {
        binding.apply {
            Glide.with(ivProfile)
                .load(data.user.profileImage ?: R.drawable.ic_default_profile)
            tvName.text = data.user.name
            tvCumulatePoint.text = data.cumulatePoint.toString()

            val uuid = data.user.id.toString()
            val itemIndex = rankingViewModel.findItemIndex(uuid, rankingListAdapter.currentList)

            itemIndex?.let { index ->
                val myInfoUuid = data.user.id.toString()
                val itemIndex =
                    rankingListAdapter.currentList.indexOfFirst { it.user.id.toString() == myInfoUuid }

                if (itemIndex != -1) {
                    val ranking = itemIndex + 1
                    binding.tvRanking.text = ranking.toString()
                }

            }
            ivProfile.setOnClickListener {
                selectImage(pickMedia)
            }
        }
    }

    private fun selectImage(pickMedia: ActivityResultLauncher<PickVisualMediaRequest>) {
        pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
    }

    private fun observeMyInfoData(event: MyInfoViewModel.Event) = when (event) {
        is MyInfoViewModel.Event.MyInfo -> {
            initMyInfo(event.myInfo)
        }

        else -> {}
    }

    private fun observeRankingData(event: RankingViewModel.Event) = when (event) {
        is RankingViewModel.Event.Ranking -> {
            rankingListAdapter.submitList(event.rankingList)
        }
    }
}
