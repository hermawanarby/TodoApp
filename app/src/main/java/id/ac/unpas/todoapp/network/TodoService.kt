package id.ac.unpas.todoapp.network

import id.ac.unpas.todoapp.network.response.TodoGetResponse
import id.ac.unpas.todoapp.network.response.TodoPostResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface TodoService {
    @GET("todo-item")
    suspend fun all() : TodoGetResponse

    @POST("todo-item")
    @FormUrlEncoded
    suspend fun insert(@Field("id") id: String, @Field("name") name: String, @Field("is_done") isDone: Int) : TodoPostResponse

}