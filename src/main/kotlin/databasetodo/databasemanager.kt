package databasetodo



import entitities.Todo
import entitities.Tododraft
import org.ktorm.database.Database
import org.ktorm.dsl.delete
import org.ktorm.dsl.eq
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.dsl.update
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

class databasemanager {

    // config
    private val hostname = "127.0.0.1"
    private val databaseName = "Ktor-todo"
    private val username = "root"
    private val password = "mohit123"

    // database
    private val ktormDatabase: Database

    init {
        val jdbcUrl = "jdbc:mysql://$hostname:3306/$databaseName?user=$username&allowPublicKeyRetrieval=true&password=$password&useSSL=false"
        ktormDatabase = Database.connect(jdbcUrl)
    }
    fun getalltodos():List<Dbtodoentitiy>{
       return  ktormDatabase.sequenceOf(Dbtodatable).toList()
    }
    fun gettodo(id:Int):Dbtodoentitiy?{
        return ktormDatabase.sequenceOf(Dbtodatable).firstOrNull { it.id eq id }
    }
    fun addtododb(draft:Tododraft):Todo{
        val insertid=ktormDatabase.insertAndGenerateKey(Dbtodatable){
            set(Dbtodatable.title,draft.title)
            set(Dbtodatable.done,draft.done)
        } as Int
        println("lll $insertid")
        return Todo(insertid,draft.title,draft.done)
    }
    fun updtodo(id:Int,draft: Tododraft):Boolean{
         val update=ktormDatabase.update(Dbtodatable){
             set(Dbtodatable.title,draft.title)
             set(Dbtodatable.done,draft.done)
             where {
                 it.id eq  id
             }
         }
        return update>0
    }
    fun deltodo(id: Int):Boolean{
        val del=ktormDatabase.delete(Dbtodatable){
            it.id eq id
        }
        return del>0
    }


}