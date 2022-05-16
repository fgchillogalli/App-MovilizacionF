package com.example.Movilizacion.model
import com.example.Movilizacion.repository.VehiculoRepository
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "conductor")
class ConductorModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var idconductor: Long? = null
    var nombre: String? = null
    var age: Long? = null
    var gender: String? = null
    var phone: String? = null
}


