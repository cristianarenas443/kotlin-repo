import com.google.gson.*
import java.io.File


/*
    Kotlin-repo
    Creado por: Ing.Cristian Arenas
    Fecha: 08/04/2022
    Repositorio público de Kotlin para desarrolladores.
*/

/*
    Funcion : main
    Input: Array<String>
    Output: none
    Type: void
    Desc: main recibe una lista de argumentos como cadenas de caracteres y ejecuta el codigo interno.
*/

fun main(args: Array<String>) {
    val file = File("src/res/resources.json").readText()
    val jsonElement = getJsonElement(file)
    print(jsonElement?.get("data"))

}


/*
    Funcion: getJsonElement
    Input: json : String
    Output: JsonObject?
    Type: fun
    Desc: getJsonElement recibe un string con el objeto json y devuelve un JsonObject
 */

fun getJsonElement(json : String) : JsonObject? {
    var jsonObject : JsonObject? = null
    try {
        jsonObject = JsonParser().parse(json).asJsonObject
    }catch (e : JsonSyntaxException){
        print("*** ERROR_PARSE_JSON: " + e.message)
    }finally {
        return jsonObject
    }
}