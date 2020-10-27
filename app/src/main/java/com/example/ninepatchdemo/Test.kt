package com.example.ninepatchdemo

sealed class Result
class Success(val msg: String) : Result()
class Failure(val error: String) : Result()
class Unknown(val unknownError: String) : Result()

fun getResultMsg(result: Result) = when (result) {
    is Success -> result.msg
    is Failure -> result.error
    else -> throw IllegalAccessError()
}




