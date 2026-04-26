package com.himanshu.gamescorekeeper

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ScorekeeperViewModel(): ViewModel() {
    private val _repository: ScoreKeeperRepository = ScoreKeeperRepository()
    private val _countA = mutableIntStateOf(_repository.getCounter().countA)
    private val _countB = mutableStateOf(_repository.getCounter().countB)

    val countA : MutableState<Int> = _countA
    val countB : MutableState<Int> = _countB

    fun addPointA(){
        _repository.addPointA()
        _countA.intValue = _repository.getCounter().countA
    }
    fun addPointB(){
        _repository.addPointB()
        _countB.value = _repository.getCounter().countB
    }
    fun reset(){
        _repository.reset()
        _countA.intValue = _repository.getCounter().countA
        _countB.value = _repository.getCounter().countB
    }
}