package controlller

import entitities.Todo
import entitities.Tododraft
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import repositiory.TodoRepository

class TodoController( var repos: TodoRepository) {
    suspend fun gettodos(call:ApplicationCall){
         call.respond(repos.getalltodo())
    }

    suspend fun gettodobyid(call: ApplicationCall):Boolean{
        val id = call.parameters["id"]?.toIntOrNull()
        if(id == null){
            call.respond(HttpStatusCode.BadRequest, "please enter the number")
            return false
        }

        val todosin=repos.gettodo(id)
        if(todosin==null){
            call.respond(HttpStatusCode.NotFound)
            return false
        }else{
            call.respond(todosin)
            return true
        }
    }
    suspend fun addtodo(call: ApplicationCall){
        val draft=call.receive<Tododraft>()
        val newtodo=repos.addtodo(draft)
        call.respond(newtodo)
    }
    suspend fun updtodo(call: ApplicationCall){
        val dr=call.receive<Todo>()
        if(dr.id!=0){
            call.respond(HttpStatusCode.BadRequest, "please don't put the id")
        }
        val draft:Tododraft=Tododraft(dr.title,dr.done)


        val id = call.parameters["id"]?.toIntOrNull()
        if(id == null){
            call.respond(HttpStatusCode.BadRequest, "please enter the number")
            return
        }

        val todosin=repos.updatetodo(id,draft)
        if(todosin==false){
            call.respond(HttpStatusCode.NotFound,"Not found")

        }else{
            call.respond(HttpStatusCode.OK)
        }
    }
//    suspend fun remtodo(call: ApplicationCall){
//        val id = call.parameters["id"]?.toIntOrNull()
//        if(id == null){
//            call.respond(HttpStatusCode.BadRequest, "please enter the number")
//            return@delete
//        }
//        val res=repos.deletetodo(id)
//        if(res){
//            call.respond(HttpStatusCode.OK)
//        }else{
//            call.respond(HttpStatusCode.NotFound)
//        }
//    }

    }
