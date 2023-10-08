package com.lenibonje.mycompose.repository

import com.lenibonje.mycompose.model.Person

class PersonRepository {

    fun getAllData(): List<Person>{
        return listOf(
            Person(id = 4860, firstName = "Sara", lastName = "Jerri", age = 29),
            Person(
                id = 3603,
                firstName = "Ola",
                lastName = "Dorothea",
                age = 69
            ),
            Person(id = 5413, firstName = "Miriam", lastName = "Shirley", age = 23),
            Person(id = 3481, firstName = "Louis", lastName = "Lucile", age = 42),
            Person(id = 5547, firstName = "Chris", lastName = "Jacklyn", age = 35),
            Person(id = 1357, firstName = "Jodie", lastName = "Issac", age = 41),
            Person(id = 1938, firstName = "Adriana", lastName = "Jolene", age = 11),
            Person(id = 9232, firstName = "Angela", lastName = "Demetrius", age = 25),
        )
    }
}