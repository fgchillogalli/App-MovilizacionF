package com.example.Movilizacion.controller

import com.example.Movilizacion.model.VehiculoModel
import com.example.Movilizacion.service.VehiculoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/vehiculo")
class vehiculoController {
    @Autowired
    lateinit var vehiculoService: VehiculoService

    @GetMapping
    fun list():List<VehiculoModel>{
        return vehiculoService.list()
    }

    @PostMapping
    fun save(@RequestBody vehiculoModel: VehiculoModel): VehiculoModel {
        return vehiculoService.save(vehiculoModel)
    }

    @PutMapping
    fun update(@RequestBody vehiculoModel: VehiculoModel):VehiculoModel{
        return vehiculoService.save(vehiculoModel)
    }

    @PatchMapping
    fun updateUno(@RequestBody vehiculoModel: VehiculoModel):VehiculoModel{
        return vehiculoService.save(vehiculoModel )
    }

    @DeleteMapping("/delete/{idvehiculo}")
    fun delete (@PathVariable("idvehiculo") idvehiculo: Long):Boolean{
        return vehiculoService.delete(idvehiculo)
    }
}