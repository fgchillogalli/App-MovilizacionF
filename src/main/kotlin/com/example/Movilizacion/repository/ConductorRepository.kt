package com.example.Movilizacion.repository

import com.example.Movilizacion.model.ConductorModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ConductorRepository: (JpaRepository<ConductorModel, Long>) {
    fun findByIdconductor(idconductor:Long?): ConductorModel?

    //@Param para decir que estamos resiviendo como parametro
    @Query(nativeQuery = true)
    fun getListaConductores ( @Param("age") age: Long?):List<ConductorModel>?
}