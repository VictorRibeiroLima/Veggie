package bt.com.veggie.burgers.estoque.controller;

import bt.com.veggie.burgers.estoque.DAO.HistoricoRepository;
import bt.com.veggie.burgers.estoque.DAO.LocalRepository;
import bt.com.veggie.burgers.estoque.DAO.ProdutoRepository;
import bt.com.veggie.burgers.estoque.entity.Historico;
import bt.com.veggie.burgers.estoque.entity.Local;
import bt.com.veggie.burgers.estoque.entity.Produto;
import bt.com.veggie.burgers.estoque.entity.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private LocalRepository localRepository;
    @Autowired
    private HistoricoRepository historicoRepository;
    @GetMapping("estoque/{Id}")
    public String estoque(Model model, @PathVariable("Id") String localId,@PageableDefault(size = 5,value = 5) Pageable pageable){
        System.out.println("Estoque "+ localId);
        Local local = localRepository.findById(Integer.parseInt(localId)).get();
        System.out.println(local.getNome());
        model.addAttribute("produtos",repository.findAllByLocalOrderByNomeAsc(local,pageable));
        model.addAttribute("local",local);
        return "produto/estoque";
    }
    @GetMapping("produto/cadastrar/{Id}")
    public String cadastro(Model model,Produto produto,@PathVariable("Id") String localId){
        model.addAttribute(produto);
        model.addAttribute("local",localId);
        return "produto/cadastro";
    }
    @PostMapping("produto/cadastrar")
    public String cadastro(RedirectAttributes redirectAttribute, Produto produto,String localId){
        if(!produto.getNome().isEmpty()) {
            produto.setNome(produto.getNome().substring(0, 1).toUpperCase() + produto.getNome().substring(1).toLowerCase());
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
    public String adicionar(int produtoId,int valor,RedirectAttributes redirectAttribute){
        Produto produto = repository.findById(produtoId).get();
        produto.setQuantidade(produto.getQuantidade() + valor);
        redirectAttribute.addFlashAttribute("msg","Entrada feita com sucesso");
        repository.save(produto);
        Historico historico = new Historico();
        historico.setProduto(produto);
        historico.setDataModificacao(new Date());
        historico.setTipo(Tipo.ENTRADA);
        historico.setHoraModificacao(new Date());
        historico.setValorAlterado(valor);
        historicoRepository.save(historico);
        return "redirect:/estoque/"+produto.getLocal().getLocalId();
    }
    @PostMapping("produto/remover")
    public String remover(int produtoId,int valor,RedirectAttributes redirectAttribute){
        Produto produto = repository.findById(produtoId).get();
        Historico historico = new Historico();
        historico.setProduto(produto);
        historico.setDataModificacao(new Date());
        historico.setTipo(Tipo.BAIXA);
        historico.setHoraModificacao(new Date());
        historico.setValorAlterado(valor);
        if(produto.getQuantidade() - valor < 0){
            redirectAttribute.addFlashAttribute("msgErr","Você não poder ter produtos negativos");
            return "redirect:/estoque/"+produto.getLocal().getLocalId();
        }
        produto.setQuantidade(produto.getQuantidade() - valor);
        redirectAttribute.addFlashAttribute("msg","Baixa feito com sucessso");
        repository.save(produto);
        historicoRepository.save(historico);
        return "redirect:/estoque/"+produto.getLocal().getLocalId();
    }
    @PostMapping("produto/excluir")
    public String excluir(int produtoId,Model model){
        Produto produto = repository.findById(produtoId).get();
        repository.delete(produto);
        model.addAttribute("msg","Produto deletado com sucesso");
        return "redirect:/estoque/"+produto.getLocal().getLocalId();
    }
}
