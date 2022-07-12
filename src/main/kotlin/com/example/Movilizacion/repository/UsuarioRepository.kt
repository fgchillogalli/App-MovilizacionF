package com.example.Movilizacion.repository

import com.example.Movilizacion.model.UsuarioModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface UsuarioRepository: (JpaRepository<UsuarioModel, Long> ) {
    fun findByIdusuario(idusuario:Long?):UsuarioModel?

    @Query (nativeQuery = true)
    fun getListaUsuario(@Param("gender") gender:String?):List<UsuarioModel>?
}