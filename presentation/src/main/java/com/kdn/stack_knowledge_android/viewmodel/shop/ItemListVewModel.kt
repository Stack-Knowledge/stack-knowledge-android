package com.kdn.stack_knowledge_android.viewmodel.shop

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.entity.item.ItemEntity
import com.kdn.domain.entity.student.MyInfoEntity
import com.kdn.domain.entity.user.UserEntity
import com.kdn.domain.usecase.shop.GetItemListUseCase
import com.kdn.stack_knowledge_android.utils.MutableEventFlow
import com.kdn.stack_knowledge_android.utils.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemListVewModel @Inject constructor(
    private val getItemListUseCase: GetItemListUseCase,
) : ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private val checkedItems = mutableListOf<ItemEntity>()

    fun getItemList() = viewModelScope.launch {
        getItemListUseCase().onSuccess {
            event(Event.Item(it))
        }.onFailure {
            Log.e("아이템 가져오기 실패", "실패 $it")
        }
    }

    fun toggleItemChecked(item: ItemEntity, isChecked: Boolean) {
        if (isChecked) {
            checkedItems.add(item)
        } else {
            checkedItems.remove(item)
        }
    }

    fun getCheckedItems(): List<ItemEntity> {
        return checkedItems
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class Item(val itemList: List<ItemEntity>) : Event()
        data class User(val user: MyInfoEntity) : Event()
    }
}