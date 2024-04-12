package dawi_cl1_victorfalconi.waexamen.controller;

import dawi_cl1_victorfalconi.waexamen.model.AnioModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnioController {
    @GetMapping("/bisisesto")
    public String inicioAnio(Model model) {
        model.addAttribute("anioModel", new AnioModel());
        model.addAttribute("mostrarMensaje", false);
        return "bisiesto";
    }

    @PostMapping("/bisiesto")
    public String calcularAnio(@ModelAttribute("anioModel") AnioModel anioModel,
                               Model model){
        int anio = anioModel.getAnio();
        String bisiesto = "";
        if((anio % 4 == 0 && anio % 100 != 0) || (anio % 100 == 0 && anio % 400 == 0)) {
            bisiesto = "es bisiesto";
        } else {
            bisiesto = "no es bisiesto";
        }
        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado", "El año " + anio
                + " " + bisiesto);
        return "bisiesto";
    }
}
