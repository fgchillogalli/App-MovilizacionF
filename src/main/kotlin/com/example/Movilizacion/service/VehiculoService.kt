package com.example.Movilizacion.service

import com.example.Movilizacion.controller.vehiculoController
import com.example.Movilizacion.model.VehiculoModel
import com.example.Movilizacion.repository.ConductorRepository
import com.example.Movilizacion.repository.VehiculoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class VehiculoService {
    @Autowired
    lateinit var vehiculoRepository: VehiculoRepository
    @Autowired
    lateinit var conductorRepository: ConductorRepository

    fun list(): List<VehiculoModel>{
        return vehiculoRepository.findAll()
    }

    fun save (vehiculoModel: VehiculoModel):VehiculoModel{
        try {
            vehiculoModel.placa?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception("La placa no puede estar vacia")

            conductorRepository.findByIdconductor(vehiculoModel.idconductor)
                ?:throw Exception ("Id de conductor no encontrada")
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
        return vehiculoRepository.save(vehiculoModel)
    }

    fun update (vehiculoModel: VehiculoModel):VehiculoModel{
        try {
            vehiculoModel.placa?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception("La Placa del vehiculo no puede estar vacia")

            vehiculoRepository.findByIdvehiculo(vehiculoModel.idvehiculo)
                ?:throw Exception ("el id ${vehiculoModel.idvehiculo} no existe")

            conductorRepository.findByIdconductor(vehiculoModel.idconductor)
                ?:throw Exception ("Id de Conductor no encontrada")
        }

        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
        return vehiculoRepository.save(vehiculoModel)
    }

    fun updateUno(vehiculoModel: VehiculoModel): VehiculoModel{
        try{
            vehiculoModel.placa?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception("La placa del vehiculo no puede estar vacia")

            val response = vehiculoRepository.findByIdvehiculo(vehiculoModel.idvehiculo)
                ?:throw Exception ("El id ${vehiculoModel.idvehiculo} no existe")
            response.apply {
                placa = vehiculoModel.placa
            }
            return vehiculoRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun delete (idvehiculo:Long): Boolean{
        try{
            val response = vehiculoRepository.findByIdvehiculo(idvehiculo)
                ?:throw Exception ("El id ${idvehiculo} no existe")
            response.apply {
                vehiculoRepository.deleteById(idvehiculo)
            }
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

}