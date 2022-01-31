package comp

import controlller.TodoController
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import repositiory.TodoRepository
import repositiory.todomysql

class component: KoinComponent{
      val todomysqlbyinj:TodoRepository by inject<todomysql>()
      val controllerbyinj:TodoController by inject<TodoController>()
}