package bt.com.veggie.burgers.estoque.controller;

import bt.com.veggie.burgers.estoque.DAO.HistoricoRepository;
import bt.com.veggie.burgers.estoque.DAO.ProdutoRepository;
import bt.com.veggie.burgers.estoque.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class HistoricoController {
    @Autowired
    private HistoricoRepository repository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @GetMapping("historico/lista/{id}")
    public String listaHistorico(@PathVariable("id") int produtoId, Model model,@PageableDefault(value = 5,size = 5) Pageable pageable){
        Produto produto = produtoRepository.findById(produtoId).get();
        model.addAttribute("historicos",repository.findAllByProduto(produto,pageable));
        model.addAttribute("produto",produto);
        return "historico/lista";
    }
}
