package com.example.lab3_20182693;

import com.example.lab3_20182693.model.bean.Ingrediente;
import com.example.lab3_20182693.model.bean.Receta;
import com.example.lab3_20182693.model.repository.IngredienteDAO;
import com.example.lab3_20182693.model.repository.RecetaDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RecetasController {

    private RecetaDAO recetaDAO = new RecetaDAO();
    private IngredienteDAO ingredienteDAO = new IngredienteDAO();

    @GetMapping({"receta/list", "receta"})
    public String listarRecetas(Model model) {
        List<Receta> listaRecetas = recetaDAO.findAll();
        model.addAttribute("listaRecetas", listaRecetas);
        return "recetasList";
    }

    @GetMapping("/receta/info/{id}")
    public String informReceta(@PathVariable("id") int id, Model model) {
        Receta recetas = recetaDAO.findById(id);
        List<Ingrediente> listaIngredientes = ingredienteDAO.findAll();
        model.addAttribute("receta", recetas);
        model.addAttribute("listaIngeredientes", listaIngredientes);
        return "recetaInfo";
    }


    @GetMapping("/receta/delete/{id}") /* popup hecho */
    public String borrarReceta(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        boolean eliminado = recetaDAO.deleteById(id);
        if (eliminado) {
            redirectAttributes.addAttribute("msg", "Se borró la receta");
        } else {
            redirectAttributes.addAttribute("msg", "No se pudo borrar la receta");
        }
        return "redirect:/receta";
    }


}
