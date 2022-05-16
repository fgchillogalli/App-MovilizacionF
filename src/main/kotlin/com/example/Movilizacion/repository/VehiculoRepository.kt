package com.example.Movilizacion.repository

import com.example.Movilizacion.model.VehiculoModel
import org.springframework.data.jpa.repository.JpaRepository

interface VehiculoRepository: (JpaRepository<VehiculoModel, Long>) {
    fun findByIdvehiculo(idvehiculo:Long?):VehiculoModel?

}