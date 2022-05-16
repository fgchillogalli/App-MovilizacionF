package com.example.Movilizacion.repository

import com.example.Movilizacion.model.UsarioModel
import org.springframework.data.jpa.repository.JpaRepository


interface UsuarioRepository: (JpaRepository<UsarioModel, Long> ) {
    fun findByIdusuario(idusuario:Long?):UsarioModel?
}