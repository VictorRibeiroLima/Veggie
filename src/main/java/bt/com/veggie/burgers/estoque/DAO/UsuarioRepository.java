package bt.com.veggie.burgers.estoque.DAO;

import bt.com.veggie.burgers.estoque.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    public Usuario findByLoginAndSenha(String login,String senha);
}
