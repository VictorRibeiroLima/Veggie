package bt.com.veggie.burgers.estoque.DAO;

import bt.com.veggie.burgers.estoque.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
