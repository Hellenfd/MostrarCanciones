package com.hfuentealba.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    @GetMapping("/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model modelo) {
        Cancion cancionActual = servicioCancion.obtenerCancionPorId(idCancion);
        modelo.addAttribute("cancion", cancionActual);
        return "editarCancion.jsp";
    }

    @PostMapping("/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
                                        BindingResult validaciones,
                                        @PathVariable("idCancion") Long idCancion) {
        if (validaciones.hasErrors()) {
            return "editarCancion.jsp";
        }

        cancion.setId(idCancion);
        servicioCancion.actualizarCancion(cancion);
        return "redirect:/canciones";
    }
    @DeleteMapping("/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
        servicioCancion.eliminaCancion(idCancion);
        return "redirect:/canciones";
    }
}
