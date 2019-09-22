package bt.com.veggie.burgers.estoque.DAO;

import bt.com.veggie.burgers.estoque.entity.Historico;
import bt.com.veggie.burgers.estoque.entity.HistoricoPK;
import bt.com.veggie.burgers.estoque.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface HistoricoRepository extends JpaRepository<Historico, HistoricoPK>, PagingAndSortingRepository<Historico,HistoricoPK> {
    public List<Historico> findAllByProduto(Produto produto);
    public Page<Historico> findAllByProduto(Produto produto,Pageable pageable);
}
