package com.himanshucountermvvm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
class CounterViewModel(): ViewModel() {
    private val _repository: CounterRepository= CounterRepository()
    private val _count= mutableStateOf(_repository.getCounter().count)
    val count=_count

    fun Increment(){
        _repository.incrementCounter()
        _count.value= _repository.getCounter().count
    }
    fun Decrement(){
        _repository.decrementCounter()
        _count.value= _repository.getCounter().count
    }

}