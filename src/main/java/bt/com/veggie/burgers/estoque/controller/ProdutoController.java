package bt.com.veggie.burgers.estoque.controller;

import bt.com.veggie.burgers.estoque.DAO.LocalRepository;
import bt.com.veggie.burgers.estoque.DAO.ProdutoRepository;
import bt.com.veggie.burgers.estoque.entity.Local;
import bt.com.veggie.burgers.estoque.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private LocalRepository localRepository;
    @GetMapping("estoque/{Id}")
    public String estoque(Model model, @PathVariable("Id") int localId){
        Local local = localRepository.findById(localId).get();
        model.addAttribute("produtos",repository.findAllByLocal(local));
        model.addAttribute("local",local.getNome());
        return "produto/estoque";
    }
    @GetMapping("produto/cadastrar")
    public String cadastro(Model model,Produto produto){
        model.addAttribute(produto);
        return "produto/cadastro";
    }
    @PostMapping("produto/cadastrar")
    public String cadastro(RedirectAttributes redirectAttribute, Produto produto){
        repository.save(produto);
        return "produto/cadastro";
    }
}
