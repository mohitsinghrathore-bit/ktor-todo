package di

import controlller.TodoController
import org.koin.dsl.bind
import org.koin.dsl.module
import repositiory.TodoRepository
import repositiory.todomysql

val  tomysqdi = module {
     factory { todomysql() } bind TodoRepository :: class
     factory { TodoController(get()) }
}