package bt.com.veggie.burgers.estoque.DAO;

import bt.com.veggie.burgers.estoque.entity.Historico;
import bt.com.veggie.burgers.estoque.entity.HistoricoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico, HistoricoPK> {
}
