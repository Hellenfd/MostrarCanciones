package com.hfuentealba.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hfuentealba.modelos.Cancion;
import com.hfuentealba.servicios.ServicioCancion;


@Controller
@RequestMapping ("/canciones")
public class ControladorCanciones {
	
    @Autowired
    private final ServicioCancion servicioCancion;

    public ControladorCanciones(ServicioCancion servicioCancion) {
        this.servicioCancion = servicioCancion;
    }

    @GetMapping("")
    public String desplegarCanciones(Model modelo) {
        List<Cancion> listaCanciones = this.servicioCancion.obtenerTodasLasCanciones();
        modelo.addAttribute("listaCanciones", listaCanciones);
        return "canciones.jsp";
    }

    @GetMapping("/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model modelo) {
        Cancion cancion = servicioCancion.obtenerCancionPorId(idCancion);
        modelo.addAttribute("cancion", cancion);
        return "detalleCancion.jsp";
    }
}
