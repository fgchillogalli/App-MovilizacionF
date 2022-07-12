package com.example.Movilizacion.repository

import com.example.Movilizacion.model.VehiculoModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface VehiculoRepository: (JpaRepository<VehiculoModel, Long>) {
    fun findByIdvehiculo(idvehiculo:Long?):VehiculoModel?

    @Modifying
    @Query(nativeQuery=true)
    fun setOtherMarc (@Param("nombre")  nombre:String?, @Param("nuevoNombre")  NuevoNombre: String?) : Integer?
}