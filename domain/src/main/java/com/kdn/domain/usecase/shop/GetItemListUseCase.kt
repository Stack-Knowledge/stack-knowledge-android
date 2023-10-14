package com.kdn.domain.usecase.shop

import com.kdn.domain.repository.item.ItemRepository
import javax.inject.Inject

class GetItemListUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke() = kotlin.runCatching {
        itemRepository.getItemList()
    }
}