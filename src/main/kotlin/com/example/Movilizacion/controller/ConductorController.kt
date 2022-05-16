package com.example.Movilizacion.controller

import com.example.Movilizacion.model.ConductorModel
import com.example.Movilizacion.service.ConductorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/conductor")

class ConductorController {
    @Autowired
    lateinit var conductorService: ConductorService

    @GetMapping
    fun list():List<ConductorModel>{
        return conductorService.list()
    }

    @GetMapping("/{idconductor}")
    fun listByIdconductor(@PathVariable ("idconductor") idconductor: Long):ConductorModel?{
        return conductorService.getByid(idconductor)
    }


    @PostMapping
    fun save(@RequestBody conductorModel: ConductorModel):ConductorModel{
        return conductorService.save(conductorModel)
    }

    @PutMapping
    fun update (@RequestBody conductorModel: ConductorModel): ConductorModel{
        return conductorService.update(conductorModel)
    }

    @PatchMapping
    fun updateUno (@RequestBody conductorModel: ConductorModel): ConductorModel{
        return conductorService.updateUno(conductorModel)
    }

    @DeleteMapping("/delete/{idconductor}")
    fun delete (@PathVariable("idconductor") idconductor: Long):Boolean{
        return conductorService.delete(idconductor )
    }

}