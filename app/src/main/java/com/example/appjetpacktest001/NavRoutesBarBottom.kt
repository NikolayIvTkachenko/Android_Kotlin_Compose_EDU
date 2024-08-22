package com.example.appjetpacktest001

sealed class NavRoutesBarBottom(val route: String) {
    object HomeBarNavigate : NavRoutesBarBottom("homebarnavigate")
    object Contacts : NavRoutesBarBottom("contacts")
    object Favorites : NavRoutesBarBottom("favorites")
}