package bt.com.veggie.burgers.estoque.controller;

import bt.com.veggie.burgers.estoque.DAO.UsuarioRepository;
import bt.com.veggie.burgers.estoque.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @GetMapping("login")
    public String logar(Usuario usuario, Model model){
        System.out.println("GET");
        model.addAttribute(usuario);
        return "usuario/login";
    }
    @PostMapping("login")
    public String logar(Usuario usuario, RedirectAttributes redirectAttributes){
        System.out.println("post");
        usuario = repository.findByLoginAndSenha(usuario.getLogin(),usuario.getSenha());
        if(usuario != null){
            redirectAttributes.addFlashAttribute("msg","logado");
            return "redirect:/login";
        }else{
            System.out.println("entrou");
            redirectAttributes.addFlashAttribute("msg","login ou senha incorretos");
            return "redirect:/locais";
        }
    }
}
