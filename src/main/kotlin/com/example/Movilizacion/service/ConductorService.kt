package com.example.Movilizacion.service

import com.example.Movilizacion.model.ConductorModel
import com.example.Movilizacion.model.VehiculoModel
import com.example.Movilizacion.repository.ConductorRepository
import com.example.Movilizacion.repository.VehiculoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import sun.security.provider.certpath.OCSPResponse.ResponseStatus
import javax.xml.ws.Response

@Service
class ConductorService {
    @Autowired
    lateinit var conductorRepository: ConductorRepository

    fun list():List <ConductorModel>{
        return conductorRepository.findAll()
    }

    fun getByid(idconductor: Long):ConductorModel?{
        return conductorRepository.findByIdconductor(idconductor)
    }

    fun save (conductorModel: ConductorModel):ConductorModel{
        try{
           conductorModel.nombre?.takeIf { it.trim().isNotEmpty() }
               ?: throw Exception ("Nombre no puede estar vacio")

            conductorModel.age?.takeIf { it > 18 }
                ?: throw Exception ("Deve ser mayor de edad, para conducir")

            conductorModel.gender?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El Genero no puede estar vacio")

            conductorModel.phone?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El telefono no puede estar vacio")
        }
        catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }

        return conductorRepository.save(conductorModel)


    }
    /*
    fun update (conductorModel: ConductorModel):ConductorModel{
        conductorRepository.findByIdconductor(conductorModel.idconductor)
            ?: throw Exception()
        return conductorRepository.save(conductorModel)
    }*/

    fun update (conductorModel: ConductorModel): ConductorModel{
        try{
            conductorModel.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El nombre no puede estar vacio")

            conductorModel.age?.takeIf { it > 18 }
                ?: throw Exception ("Tiene que ser mayor de edad para conducir")

            conductorModel.gender?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El Genero no puede estar vacio")

            conductorModel.phone?.takeIf { it.trim().isNotEmpty()}
                ?: throw Exception ("El telefono no puede estar vacio")

            conductorRepository.findByIdconductor(conductorModel.idconductor)
                ?: throw Exception ("El id ${conductorModel.idconductor} no existe")
        }
        catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
        return conductorRepository.save(conductorModel)
    }

    fun updateUno (conductorModel: ConductorModel):ConductorModel{
        try{
            conductorModel.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El nombre no puede estar vacio")

            conductorModel.age?.takeIf { it < 18 }
                ?: throw Exception ("Tiene que ser mayor de edad para conducir")

            conductorModel.gender?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El Genero no puede estar vacio")

            conductorModel.phone?.takeIf { it.trim().isNotEmpty()}
                ?: throw Exception ("El telefono no puede estar vacio")

            val response = conductorRepository.findByIdconductor(conductorModel.idconductor)
                ?: throw Exception ("El id ${conductorModel.idconductor} no existe")
            response.apply {
                nombre = conductorModel.nombre
            }
            return conductorRepository.save(response)
        }
        catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }

    }

    fun delete (idconductor:Long): Boolean{
            try{
                val response = conductorRepository.findByIdconductor(idconductor)
                    ?:throw Exception ("El id ${idconductor} no existe")
                response.apply {
                    conductorRepository.deleteById(idconductor)
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