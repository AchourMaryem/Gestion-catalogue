package com.poly.gestioncataloguesg1.controleur;

import com.poly.gestioncataloguesg1.entities.Produit;
import com.poly.gestioncataloguesg1.service.IServiceCategorie;
import com.poly.gestioncataloguesg1.service.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProduitControlleur {

    private final IServiceProduit serviceProduit; // Utilisez 'final' pour injection de dépendance
    private final IServiceCategorie serviceCategorie;

    @GetMapping("/index")
    public String getAllProducts(Model m) {
        List<Produit> l = serviceProduit.getAllProducts();
        m.addAttribute("products", l);
        return "vue";
    }

    @GetMapping("/home")
    public String getProducts(Model m, @RequestParam(name = "mc", defaultValue = "") String mc) {
        m.addAttribute("data", serviceProduit.getProductByMc(mc));
        m.addAttribute("mc", mc);
        return "vue";
    }

    @GetMapping("/delete/{id}")
    public String deleteProducts(@PathVariable Long id) {
        serviceProduit.deleteProduct(id);
        return "redirect: /home";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model m) {
        m.addAttribute("produit", serviceProduit.getProduct(id));
        m.addAttribute("categorie", serviceCategorie.getAllCategorie());
        return "ajouter";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Produit p, Model m) {
        serviceProduit.saveProduct(p);
        return "redirect:/home";
    }

    @GetMapping("/formProduit")
    public String redirection(Model m)
    {
        m.addAttribute("categorie",serviceCategorie.getAllCategorie());
        m.addAttribute("produit",new Produit());
        return "ajouter";
    }
}
