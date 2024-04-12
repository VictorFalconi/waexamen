package dawi_cl1_victorfalconi.waexamen.controller;

import dawi_cl1_victorfalconi.waexamen.model.AlmacenModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlmacenController {
    @GetMapping("/almacen")
    public String inicioAlmacen(Model model) {
        model.addAttribute("almacenModel", new AlmacenModel());
        model.addAttribute("mostrarMensaje", false);
        return "almacen";
    }

    @PostMapping("/almacen")
    public String calcularAlmacen(@ModelAttribute("almacenModel") AlmacenModel almacenModel
            , Model model){
        int cantidad = almacenModel.getCantidad();
        double monto = 0;
        String descuento = "";
        if(cantidad > 20){
            monto = almacenModel.getPrecio() * cantidad * 0.9;
            descuento = "10%";
        } else if(cantidad > 10){
            monto = almacenModel.getPrecio() * cantidad * 0.95;
            descuento = "5%";
        } else {
            monto = almacenModel.getPrecio() * cantidad;
            descuento = "0%";
        }
        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado", "Su total a pagar es S/"
                + String.format("%.2f", monto) + " con un " + descuento + " de descuento");
        return "almacen";
    }
}
