package dawi_cl1_victorfalconi.waexamen.controller;

import dawi_cl1_victorfalconi.waexamen.model.AprobadoModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AprobadoController {
    @GetMapping("/aprobado")
    public String inicioAprobado(Model model){
        model.addAttribute("aprobadoModel", new AprobadoModel());
        model.addAttribute("mostrarMensaje", false);
        return "aprobado";
    }

    @PostMapping("/aprobado")
    public String calcularAprobado(@ModelAttribute("aprobadoModel") AprobadoModel aprobadoModel,
                                   Model model){
        double promedio = (double) (aprobadoModel.getNota1() + aprobadoModel.getNota2()
                + aprobadoModel.getNota3()) / 3;
        String aprobado = "";
        if(promedio >= 70) {
            aprobado = "aprobado";
        } else {
            aprobado = "desaprobado";
        }
        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado", "El promedio del alumno es "
                + String.format("%.2f", promedio) + ", por lo tanto esta " + aprobado);
        return "aprobado";
    }
}
