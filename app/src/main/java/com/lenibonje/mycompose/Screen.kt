package com.lenibonje.mycompose

const val DETAIL_ARG_KEY = "id"
const val DETAIL_ARG_KEY2 = "name"

sealed class Screen(val route: String) {

    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen/$DETAIL_ARG_KEY"){
        fun passId(id: Int): String {
            return this.route.replace("{$DETAIL_ARG_KEY}", id.toString())
        }

//        fun passIdAndName(name: String): String {
//            return this.route.replace("{$DETAIL_ARG_KEY2}", name)
//        }
    }

}