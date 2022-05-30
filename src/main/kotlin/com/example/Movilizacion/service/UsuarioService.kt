package com.example.Movilizacion.service

import com.example.Movilizacion.model.UsarioModel
import com.example.Movilizacion.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    fun list(): List <UsarioModel>{
        return usuarioRepository.findAll()
    }

    fun getByid (idusuario: Long):UsarioModel?{
        return usuarioRepository.findByIdusuario(idusuario)
    }

    fun getGender(gender:String?):List<UsarioModel>?{
        return usuarioRepository.israelSanto(gender)
    }

    fun save (usuarioModel: UsarioModel):UsarioModel{
        try {
            usuarioModel.nombre?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception ("El nombre no puede estar vacio")

            usuarioModel.age?.takeIf { it > 0 && it < 100 }
                ?:throw Exception ("Ingrese una edad valida")

            usuarioModel.gender?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception ("El genero no puede estar vacio")

            usuarioModel.phone?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception ("El numero de telefono no pude estar vacio")

            usuarioModel.email?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception ("El correo no puede estar vacio")
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
        return usuarioRepository.save(usuarioModel)
    }


    fun update (usuarioModel: UsarioModel):UsarioModel{
        try {
            usuarioModel.nombre?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception ("El nombre no puede estar vacio")

            usuarioModel.age?.takeIf { it > 0 && it < 100 }
                ?:throw Exception ("Ingrese una edad valida")

            usuarioModel.gender?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception ("El genero no puede estar vacio")

            usuarioModel.phone?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception ("El numero de telefono no pude estar vacio")

            usuarioModel.email?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception ("El correo no puede estar vacio")

            usuarioRepository.findByIdusuario(usuarioModel.idusuario)
            //Signo Elvis Operato, si devuelve un null, ejecuta este
            //Lanza error :v
                ?: throw Exception("El id ${usuarioModel.idusuario} no existe")
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }

        return usuarioRepository.save(usuarioModel)
    }

    fun updateUno(usuarioModel: UsarioModel):UsarioModel{
        try {
            usuarioModel.nombre?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception ("El nombre no puede estar vacio")

            usuarioModel.age?.takeIf { it > 0 && it < 100 }
                ?:throw Exception ("Ingrese una edad valida")

            usuarioModel.gender?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception ("El genero no puede estar vacio")

            usuarioModel.phone?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception ("El numero de telefono no pude estar vacio")

            usuarioModel.email?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception ("El correo no puede estar vacio")

            //busca el id del objeto a actualizar
            //si existe le asigna a la variable response
            val response=usuarioRepository.findByIdusuario(usuarioModel.idusuario)
                ?: throw Exception("El id ${usuarioModel.idusuario} no existe")
                //actualizo solo el nombre
            response.apply {
                nombre=usuarioModel.nombre
            }
            return usuarioRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun delete (idusuario:Long): Boolean{
        try{
            usuarioRepository.findByIdusuario(idusuario)
                ?:throw Exception ("El id ${idusuario} no existe")
            usuarioRepository.deleteById(idusuario)

            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }
}