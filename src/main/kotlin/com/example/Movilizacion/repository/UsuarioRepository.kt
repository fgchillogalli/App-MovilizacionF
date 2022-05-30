package com.example.Movilizacion.repository

import com.example.Movilizacion.model.UsarioModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface UsuarioRepository: (JpaRepository<UsarioModel, Long> ) {
    fun findByIdusuario(idusuario:Long?):UsarioModel?

    @Query (nativeQuery = true)
    fun israelSanto(@Param("gender") gender:String?):List<UsarioModel>?
}