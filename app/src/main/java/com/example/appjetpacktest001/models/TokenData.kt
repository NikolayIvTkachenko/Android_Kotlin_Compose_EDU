package com.example.appjetpacktest001.models

data class TokenData(val token: String, val opt: String? = null){
    override fun toString(): String {
        return "TokenData(token='$token', opt=$opt)"
    }
}