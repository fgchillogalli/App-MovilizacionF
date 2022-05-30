package com.example.Movilizacion.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="vehiculo")
class VehiculoModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var idvehiculo: Long? = null
    @Column(name = "conductor_id")
    var conductorId: Long? = null
    var placa: String? = null
    var marca: String? = null
}