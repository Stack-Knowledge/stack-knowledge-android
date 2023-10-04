package com.kdn.domain.usecase.shop

import com.kdn.domain.repository.ItemRepository
import javax.inject.Inject

class GetItemListUseCase @Inject constructor(
    private val goodsRepository: ItemRepository,
) {
    suspend operator fun invoke() = kotlin.runCatching {
        goodsRepository.getGoodsList()
    }
}