package com.example.Movilizacion.service

import com.example.Movilizacion.model.UsuarioModel
import com.example.Movilizacion.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    fun list(): List <UsuarioModel>{
        return usuarioRepository.findAll()
    }

    fun getByid (idusuario: Long):UsuarioModel?{
        return usuarioRepository.findByIdusuario(idusuario)
    }

    fun getGender(gender:String?):List<UsuarioModel>?{
        return usuarioRepository.getListaUsuario(gender)
    }

    fun save (usuarioModel: UsuarioModel):UsuarioModel{
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


    fun update (usuarioModel: UsuarioModel):UsuarioModel{
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

    fun updateUno(usuarioModel: UsuarioModel):UsuarioModel{
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

    fun multiplicacion(coeficiente: Int, digito: Int): Int {
        val response = coeficiente * digito
        if (response >= 10)
            return response - 9
        return response
    }

    fun SumaValores(nui: String): Int {
        var sum: Int = 0
        for (i in 0..8) {
            val coeficiente = if (i % 2 == 0) 2 else 1
            sum += multiplicacion(coeficiente, Integer.parseInt(nui[i].toString()))
        }
        return sum
    }

    fun findDecenaSuperior(sum: Int): Int {

        val division: Int = sum / 10
        val decenaSuperior: Int = (division + 1) * 10
        var response: Int = decenaSuperior - sum
        if (response == 10)
            response = 0

        return response
    }

    fun validarCedula(cedula: String): Boolean {
        val sum = SumaValores(cedula)
        val lastDig = findDecenaSuperior(sum)

        val lastDigCedString = cedula.last()
        val lastDigCedInt = Integer.parseInt(lastDigCedString.toString())

        if (lastDigCedInt == lastDig)
            return true
        return false

    }

}