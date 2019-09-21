package bt.com.veggie.burgers.estoque.DAO;

import bt.com.veggie.burgers.estoque.entity.Historico;
import bt.com.veggie.burgers.estoque.entity.HistoricoPK;
import bt.com.veggie.burgers.estoque.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoRepository extends JpaRepository<Historico, HistoricoPK> {
    public List<Historico> findAllByProduto(Produto produto);
}
