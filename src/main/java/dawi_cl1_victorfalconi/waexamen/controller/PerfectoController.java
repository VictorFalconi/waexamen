package dawi_cl1_victorfalconi.waexamen.controller;

import dawi_cl1_victorfalconi.waexamen.model.PerfectoModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PerfectoController {
    @GetMapping("/perfecto")
    public String inicioPerfecto(Model model){
        model.addAttribute("perfectoModel", new PerfectoModel());
        model.addAttribute("mostrarMensaje", false);
        return "perfecto";
    }

    @PostMapping("/perfecto")
    public String calcularPerfecto(@ModelAttribute("perfectoModel") PerfectoModel perfectoModel,
                                   Model model){
        String numerosPerfectos = "";
        if(perfectoModel.getLimite() < 6) {
            numerosPerfectos = "no hay ninguno";
        }
        else if(perfectoModel.getLimite() < 28) {
            numerosPerfectos = "solo 6";
        }
        else if(perfectoModel.getLimite() < 496) {
            numerosPerfectos = "6 y 28";
        }
        else if(perfectoModel.getLimite() < 8128) {
            numerosPerfectos = "6, 28 y 496";
        }
        else {
            numerosPerfectos = "6, 28, 496 y 8128";
        }
        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado", "Los numeros perfectos hasta" +
                " el limite " + perfectoModel.getLimite() + " son: " + numerosPerfectos);
        return "perfecto";
    }
}
