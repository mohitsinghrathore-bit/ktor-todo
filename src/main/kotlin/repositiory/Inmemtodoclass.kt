package repositiory

import entitities.Todo
import entitities.Tododraft

class Inmemtodoclass:TodoRepository {
    private val todo= mutableListOf<Todo>(
        Todo(1,"hi",true),
        Todo(2,"hey",false)
    )
    override fun getalltodo(): List<Todo> {
        return todo
    }

    override fun gettodo(id: Int): Todo? = todo.firstOrNull { it.id == id }

    override fun addtodo(draft: Tododraft): Todo {
        val newtodo=Todo(id = todo.size + 1,
            title = draft.title,
            done = draft.done)
        todo.add(newtodo)
        return newtodo

    }

    override fun updatetodo(id: Int, draft: Tododraft): Boolean {
        val updtodo=todo.firstOrNull{it.id==id} ?: return false
        updtodo.title=draft.title
        updtodo.done=draft.done
        return true
    }

    override fun deletetodo(id: Int):Boolean  {
        val remtodo=todo.firstOrNull{it.id==id} ?: return false
        todo.remove(remtodo)
        return true
    }

}