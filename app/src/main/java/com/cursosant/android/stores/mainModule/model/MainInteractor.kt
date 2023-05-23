package com.cursosant.android.stores.mainModule.model

import com.cursosant.android.stores.StoreApplication
import com.cursosant.android.stores.common.entities.StoreEntity

class MainInteractor {

    interface storesCallback{
        fun getStoresCallback(callback: MutableList<StoreEntity>)
    }

    fun getStores(callback: storesCallback){
        doAsync {
            val storesList = StoreApplication.database.storeDao().getAllStores()
            uiThread {
                callback.getStoresCallback(storesList)
            }
        }
    }
}