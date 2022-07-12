package com.example.Movilizacion.controller

import com.example.Movilizacion.model.UsuarioModel
import com.example.Movilizacion.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class UsuarioController {
    @Autowired
    lateinit var usuarioService: UsuarioService

    @GetMapping
    fun list():List<UsuarioModel>{
        return usuarioService.list()
    }

    @GetMapping("/{idusuario}")
    fun getByid (@PathVariable ("idusuario")  idusuario: Long):UsuarioModel?{
        return usuarioService.getByid(idusuario)
    }

    @GetMapping("/gender/{gender}")
    fun getGender(@PathVariable("gender") gender:String?):List<UsuarioModel>?{
        return usuarioService.getGender(gender)
    }

    @PostMapping
    fun save(@RequestBody usuarioModel: UsuarioModel):UsuarioModel{
        return usuarioService.save(usuarioModel)
    }

    @PutMapping
    fun update (@RequestBody usuarioModel: UsuarioModel):UsuarioModel{
        return usuarioService.update(usuarioModel)
    }

    @PatchMapping
    fun updateUno(@RequestBody usuarioModel: UsuarioModel):UsuarioModel{
        return usuarioService.updateUno(usuarioModel)
    }

    @DeleteMapping("/delete/{idusuario}")
    fun delete (@PathVariable("idusuario") idusuario: Long):Boolean{
        return usuarioService.delete(idusuario)
    }

}