package com.example.plugins

import controlller.*
import comp.component
import entitities.Todo
import entitities.Tododraft
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*

fun Application.configureRouting() {
    install(ContentNegotiation) {
          gson {  }
    }

    routing {
          val Comp=component()
          val repos=Comp.todomysqlbyinj
          val todocontroller =Comp.controllerbyinj

        get("/") {
                call.respondText("Hello World!")
            }
        get("/Todo"){
            todocontroller.gettodos(call)
        }
        get("/Todo/{id}"){
            if(!todocontroller.gettodobyid(call)){
                return@get
            }
        }
        put("/Todo/{id}"){
            todocontroller.updtodo(call)

        }
//        post("/Todo"){
//            todocontroller.addtodo(call)
//        }
//        put("/Todo/id"){
//            todocontroller.updtodo(call)
//        }
//        delete("Todo/id"){
//            todocontroller.remtodo(call)
//        }
//        //getalltodo()
//        Todobyid()
//        addTodo()
//        updTodo()
//        removeTodo()
    }
}
