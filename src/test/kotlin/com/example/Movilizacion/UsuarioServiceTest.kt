package com.example.Movilizacion

import com.example.Movilizacion.service.UsuarioService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UsuarioServiceTest {
    @Autowired
    lateinit var usuarioService: UsuarioService
    @Test
    fun multiplicacionWhenLessThanTen (){
        val response=usuarioService.multiplicacion(1,7)
        Assertions.assertEquals(7,response)
    }

    @Test
    fun multiplicacionWhenMajorThanTen(){
        val response=usuarioService.multiplicacion(2,7)
        Assertions.assertEquals(5,response)
    }

    @Test
    fun ValidarSumaNui(){
        val response=usuarioService.SumaValores("0106438724")
        Assertions.assertEquals(36,response)
    }

    @Test
    fun validarDecenaSuperiorCuandoNoEsCero(){
        val response = usuarioService.findDecenaSuperior(25)
        Assertions.assertEquals(5, response)
    }


    @Test
    fun validarDecenaSuperiorCuandoEsCero(){
        val response = usuarioService.findDecenaSuperior(10)
        Assertions.assertEquals(0, response)
    }

    @Test
    fun validarCedulaIsValida(){
        val response = usuarioService.validarCedula("0106438724")
        Assertions.assertEquals(true, response)
    }

    @Test
    fun validarCedulaIsFalse(){
        val response = usuarioService.validarCedula("0106438728")
        Assertions.assertEquals(false, response)
    }

}