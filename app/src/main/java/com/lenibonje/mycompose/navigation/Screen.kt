package com.lenibonje.mycompose.navigation

const val DETAIL_ARG_KEY = "id"
const val DETAIL_ARG_KEY2 = "name"

const val AUTH_ROUTE = "auth"
const val ROOT_ROUTE = "root"

sealed class Screen(val route: String) {

    object Home: Screen(route = "home_screen")
    object Login: Screen(route = "login_screen")
    object SignUp: Screen(route = "signup_screen")
    object Detail: Screen(route = "detail_screen/$DETAIL_ARG_KEY"){
        fun passId(id: Int): String {
            return this.route.replace("{$DETAIL_ARG_KEY}", id.toString())
        }

//        fun passIdAndName(name: String): String {
//            return this.route.replace("{$DETAIL_ARG_KEY2}", name)
//        }
    }

    object DetailB: Screen(route = "detail_screen_b")

}