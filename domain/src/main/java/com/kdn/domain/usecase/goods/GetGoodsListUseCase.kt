package com.kdn.domain.usecase.goods

import com.kdn.domain.repository.GoodsRepository
import javax.inject.Inject

class GetGoodsListUseCase @Inject constructor(
    private val goodsRepository: GoodsRepository,
) {
    suspend operator fun invoke() = kotlin.runCatching {
        goodsRepository.getGoodsList()
    }
}