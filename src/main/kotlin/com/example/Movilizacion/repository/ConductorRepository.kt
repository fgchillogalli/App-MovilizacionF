package com.example.Movilizacion.repository

import com.example.Movilizacion.model.ConductorModel
import org.springframework.data.jpa.repository.JpaRepository

interface ConductorRepository: (JpaRepository<ConductorModel, Long>) {
    fun findByIdconductor(idconductor:Long?): ConductorModel?
}