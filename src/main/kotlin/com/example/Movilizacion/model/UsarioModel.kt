package com.example.Movilizacion.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="usuarios")
class UsarioModel {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(updatable = false)

        var idusuario: Long? = null
        var nombre: String? = null
        var age: Long? = null
        var gender: String? = null
        var phone: String? = null
        var email: String? = null
}