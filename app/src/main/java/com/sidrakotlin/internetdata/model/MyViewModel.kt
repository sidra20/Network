package com.sidrakotlin.internetdata.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sidrakotlin.internetdata.network.ApiService
import com.sidrakotlin.internetdata.network.Photos
import com.sidrakotlin.internetdata.network.PhotosApi
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

    private val status = MutableLiveData<String>()
    val list:LiveData<String>
    get() = status

    init{
        getPhotos()
    }
    private fun getPhotos() = viewModelScope.launch{
            try{
                val result = PhotosApi.retrofitService.getPhotos()
                status.value = "Succeed in retrieving ${result.size} photos"
                //status.value = "${result}"
                //status.value=result
            }
            catch (e:Exception){
                status.value = "Failed ${e.message}"
            }
        }

}