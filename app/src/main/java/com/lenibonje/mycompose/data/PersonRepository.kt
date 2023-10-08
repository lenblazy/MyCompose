package com.lenibonje.mycompose.data

import javax.inject.Inject

class PersonRepository @Inject constructor(
    personDao: PersonDao
) {
    val readAll = personDao.readAll()
}