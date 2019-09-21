package bt.com.veggie.burgers.estoque.DAO;

import bt.com.veggie.burgers.estoque.entity.Local;
import bt.com.veggie.burgers.estoque.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
    public List<Produto> findAllByLocal(Local local);
}
