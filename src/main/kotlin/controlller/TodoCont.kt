//package controlller
//
//import comp.component
//import entitities.Todo
//import entitities.Tododraft
//import io.ktor.http.*
//import io.ktor.server.application.*
//import io.ktor.server.request.*
//import io.ktor.server.response.*
//import io.ktor.server.routing.*
//import repositiory.TodoRepository
//
//var repos: TodoRepository =component().todomysqlbyinj
//fun Route.getalltodo(){
//    get("/Todo"){
//        call.respond(repos.getalltodo())
//    }
//}
//fun Route.Todobyid(){
//    get("/Todo/{id}") {
//        val id = call.parameters["id"]?.toIntOrNull()
//        if(id == null){
//            call.respond(HttpStatusCode.BadRequest, "please enter the number")
//            return@get
//        }
//
//        val todosin=repos.gettodo(id)
//        if(todosin==null){
//            call.respond(HttpStatusCode.NotFound)
//            return@get
//        }else{
//            call.respond(todosin)
//        }
//
//    }
//}
//
//fun Route.addTodo(){
//    post("/Todo"){
//        ///       if(typeOf<Tododraft>(call.receiveOrNull().done))
//        val draft=call.receive<Tododraft>()
//        val newtodo=repos.addtodo(draft)
//        call.respond(newtodo)
//        //call.respondText("jkklll")
//    }
//}
//fun Route.removeTodo(){
//    delete("/Todo/{id}"){
//
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
//}
//
//fun Route.updTodo(){
//    put("/Todo/{id}"){
//        val dr=call.receive<Todo>()
//        if(dr.id!=0){
//            call.respond(HttpStatusCode.BadRequest, "please don't put the id")
//            return@put
//        }
//        val draft:Tododraft=Tododraft(dr.title,dr.done)
//
//
//        val id = call.parameters["id"]?.toIntOrNull()
//        if(id == null){
//            call.respond(HttpStatusCode.BadRequest, "please enter the number")
//            return@put
//        }
//
//        val todosin=repos.updatetodo(id,draft)
//        if(todosin==false){
//            call.respond(HttpStatusCode.NotFound,"Not found")
//            return@put
//        }else{
//            call.respond(HttpStatusCode.OK)
//        }
//
//    }
//}