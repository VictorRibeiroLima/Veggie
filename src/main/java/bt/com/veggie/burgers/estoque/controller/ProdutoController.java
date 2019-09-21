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
    public String estoque(Model model, @PathVariable("Id") String localId){
        System.out.println("Estoque "+ localId);
        Local local = localRepository.findById(Integer.parseInt(localId)).get();
        System.out.println(local.getNome());
        model.addAttribute("produtos",repository.findAllByLocal(local));
        model.addAttribute("local",local);
        return "produto/estoque";
    }
    @GetMapping("produto/cadastrar/{Id}")
    public String cadastro(Model model,Produto produto,@PathVariable("Id") String localId){
        System.out.println(localId);
        model.addAttribute(produto);
        model.addAttribute("local",localId);
        return "produto/cadastro";
    }
    @PostMapping("produto/cadastrar")
    public String cadastro(RedirectAttributes redirectAttribute, Produto produto,String localId){
        System.out.println(localId);
        if(!produto.getNome().isEmpty()) {

            System.out.println("oi");
            produto.setLocal(localRepository.findById(Integer.parseInt(localId)).get());
            redirectAttribute.addFlashAttribute("msg", "produto cadastrado");
            repository.save(produto);
            return "redirect:/estoque/"+localId;
        }else{
            redirectAttribute.addFlashAttribute("msg", "Nome é um campo obrigatorio");
            return "redirect:/produto/cadastrar/"+localId;
        }
    }
    @PostMapping("produto/adicionar")
    public String adicionar(int produtoId,int valor){
        Produto produto = repository.findById(produtoId).get();
        produto.setQuantidade(produto.getQuantidade() + valor);
        repository.save(produto);
        return "redirect:/estoque/"+produto.getLocal().getLocalId();
    }
    @PostMapping("produto/remover")
    public String remover(int produtoId,int valor){
        Produto produto = repository.findById(produtoId).get();
        produto.setQuantidade(produto.getQuantidade() - valor);
        repository.save(produto);
        return "redirect:/estoque/"+produto.getLocal().getLocalId();
    }
}
