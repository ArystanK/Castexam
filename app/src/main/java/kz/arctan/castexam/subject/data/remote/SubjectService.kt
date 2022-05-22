package kz.arctan.castexam.subject.data.remote

import kz.arctan.castexam.common.data.dto.ExamDto
import kz.arctan.castexam.subject.data.remote.dto.SubjectDto
import retrofit2.Response
import retrofit2.http.*

interface SubjectService {
    @POST("subject/create")
    suspend fun createSubject(@Body title: String): Response<*>

    @GET("subject/findAll")
    suspend fun getAllSubjects(): List<SubjectDto>

    @PUT("subject/update")
    suspend fun updateSubject(@Body newTitle: String, @Query("id") id: Int): Response<*>

    @DELETE("subject/delete")
    suspend fun deleteSubject(@Query("id") id: Int): Response<*>

    @GET("subject/id")
    suspend fun getSubject(@Query("id") id: Int): SubjectDto

    @GET("subject/exams")
    suspend fun getExams(@Query("id") id: Int): List<ExamDto>
}