package repositiory

import entitities.Todo
import entitities.Tododraft

interface TodoRepository {
    fun getalltodo() :List<Todo>

    fun gettodo(id:Int):Todo?

    fun addtodo(draft:Tododraft):Todo

    fun updatetodo(id:Int,draft:Tododraft):Boolean

    fun deletetodo(id:Int):Boolean
}