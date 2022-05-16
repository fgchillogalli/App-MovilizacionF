package com.example.Movilizacion.controller

import com.example.Movilizacion.model.UsarioModel
import com.example.Movilizacion.model.VehiculoModel
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
    fun list():List<UsarioModel>{
        return usuarioService.list()
    }

    @GetMapping("/{idusuario}")
    fun getByid (@PathVariable ("idusuario")  idusuario: Long):UsarioModel?{
        return usuarioService.getByid(idusuario)
    }

    @PostMapping
    fun save(@RequestBody usarioModel: UsarioModel):UsarioModel{
        return usuarioService.save(usarioModel)
    }

    @PutMapping
    fun update (@RequestBody usarioModel: UsarioModel):UsarioModel{
        return usuarioService.update(usarioModel)
    }

    @PatchMapping
    fun updateUno(@RequestBody usarioModel: UsarioModel):UsarioModel{
        return usuarioService.updateUno(usarioModel)
    }

    @DeleteMapping("/delete/{idusuario}")
    fun delete (@PathVariable("idusuario") idusuario: Long):Boolean{
        return usuarioService.delete(idusuario)
    }

}