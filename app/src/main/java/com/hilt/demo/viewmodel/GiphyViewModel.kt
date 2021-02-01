package com.hilt.demo.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.hilt.demo.model.Data
import com.hilt.demo.repository.NetworkRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import java.lang.Exception

class GiphyViewModel @ViewModelInject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val networkRepository: NetworkRepository
) :
    ViewModel(), LifecycleObserver {

    var loading: MutableLiveData<Boolean> = MutableLiveData()
    private val errorOnAPI = MutableLiveData<String>()
    var empListMutableLiveData = MutableLiveData<List<Data>>()


    fun fetchEmpInfo() {

        viewModelScope.launch(dispatcher) {
            try {
                val response = networkRepository.fetchData()
                if (response.isSuccessful) {
                    empListMutableLiveData.postValue(response.body()?.data)
                    loading.postValue(false)
                } else {
                    loading.postValue(false)
                    errorOnAPI.postValue("Something went wrong::${response.message()}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                loading.postValue(false)
                errorOnAPI.postValue("Something went wrong::${e.localizedMessage}")

            } finally {

            }
        }
    }

    fun fetchError(): LiveData<String> = errorOnAPI
    fun fetchLoadStatus(): LiveData<Boolean> = loading
    fun fetchUsersLiveData(): LiveData<List<Data>> = empListMutableLiveData

    fun emptyFunc() {
        while (true) {

        }
    }

}