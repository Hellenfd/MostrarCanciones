package com.hfuentealba.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hfuentealba.modelos.Cancion;
import com.hfuentealba.servicios.ServicioCancion;

import jakarta.validation.Valid;


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
    
    @GetMapping("/formulario/agregar/{idCancion}")
    public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion, Model model) {
        return "agregarCancion.jsp";
    }

    @PostMapping("/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion nuevaCancion,
                                          BindingResult validaciones) {
        if (validaciones.hasErrors()) {
            return "agregarCancion.jsp";
        }
        this.servicioCancion.agregarCancion(nuevaCancion);
        return "redirect:/canciones"; //
    }
}
