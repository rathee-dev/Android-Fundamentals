package com.himanshu.gamescorekeeper

data class ScorekeeperModel(var countA : Int, var countB : Int)

class ScoreKeeperRepository{
    private var _counter = ScorekeeperModel(0,0)

    fun  getCounter()= _counter
    fun addPointA(){
        _counter.countA++
    }
    fun addPointB(){
        _counter.countB++
    }
    fun reset(){
        _counter.countA = 0
        _counter.countB = 0
    }
}