package repositiory

import databasetodo.databasemanager
import entitities.Todo
import entitities.Tododraft

class todomysql:TodoRepository {
    private val Databasemysql=databasemanager()
    override fun getalltodo(): List<Todo> {
         return Databasemysql.getalltodos().map { Todo(it.id,it.title,it.done ) }
    }

    override fun gettodo(id: Int): Todo? {
        return Databasemysql.gettodo(id)?.let {Todo(it.id,it.title,it.done)}
    }

    override fun addtodo(draft: Tododraft): Todo {
        return Databasemysql.addtododb(draft)
    }

    override fun updatetodo(id: Int, draft: Tododraft): Boolean {
       return Databasemysql.updtodo(id,draft)
    }

    override fun deletetodo(id: Int): Boolean {
      return Databasemysql.deltodo(id)
    }
}