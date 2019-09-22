package bt.com.veggie.burgers.estoque.controller;

import bt.com.veggie.burgers.estoque.DAO.LocalRepository;
import bt.com.veggie.burgers.estoque.entity.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LocalController {
    @Autowired
    private LocalRepository repository;
    @GetMapping("locais")
    public String listarLocais( Model model){
        model.addAttribute("locais",repository.findAll(Sort.by(Sort.Direction.ASC,"nome")));
        return "local/locais";
    }
    @GetMapping("local/cadastrar")
    public String cadastrar(Model model,Local local){
        model.addAttribute(local);
        return "local/cadastro";
    }
    @PostMapping("local/cadastrar")
    public String cadastrar(RedirectAttributes redirectAttributes, Local local){
        local.setNome(local.getNome().substring(0, 1).toUpperCase() + local.getNome().substring(1).toLowerCase());
        redirectAttributes.addFlashAttribute("msgS","Cadastrado");
        repository.save(local);
        return "redirect:/locais";
    }
    @PostMapping("local/excluir")
    public String excluir(RedirectAttributes redirectAttributes, Local local){
        redirectAttributes.addFlashAttribute("msgE","Local excluido");
        repository.delete(local);
        return "redirect:/locais";
    }
}
