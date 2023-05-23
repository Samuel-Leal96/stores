package com.cursosant.android.stores.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cursosant.android.stores.StoreApplication
import com.cursosant.android.stores.common.entities.StoreEntity
import com.cursosant.android.stores.mainModule.model.MainInteractor

class MainViewModel: ViewModel() {

    private var interactor: MainInteractor = MainInteractor()

    init {
        loadStores()
    }

    private val stores:MutableLiveData<List<StoreEntity>> by lazy {
        MutableLiveData<List<StoreEntity>>().also {
            loadStores()
        }
    }

    fun getStores(): LiveData<List<StoreEntity>>{
        return stores
    }

    private fun loadStores(){
        interactor.getStores()
        stores.value = storesList
    }

}