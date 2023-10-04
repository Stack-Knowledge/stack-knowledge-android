package com.kdn.stack_knowledge_android.viewmodel.shop

import androidx.lifecycle.ViewModel
import com.kdn.domain.usecase.auth.SaveTheLoginDataUseCase
import com.kdn.domain.usecase.shop.BuyItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BuyViewModel @Inject constructor(
    private val buyGoodsUseCase: BuyItemUseCase,
    private val saveTheLoginDataUseCase: SaveTheLoginDataUseCase,
) : ViewModel() {
    
}