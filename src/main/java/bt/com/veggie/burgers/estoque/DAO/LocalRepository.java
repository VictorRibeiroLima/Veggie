package bt.com.veggie.burgers.estoque.DAO;

import bt.com.veggie.burgers.estoque.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalRepository extends JpaRepository<Local,Integer> {
}
