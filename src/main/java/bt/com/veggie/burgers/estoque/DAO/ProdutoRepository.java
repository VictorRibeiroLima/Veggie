package bt.com.veggie.burgers.estoque.DAO;

import bt.com.veggie.burgers.estoque.entity.Local;
import bt.com.veggie.burgers.estoque.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer>, PagingAndSortingRepository<Produto,Integer> {
    public List<Produto> findAllByLocalOrderByNomeAsc(Local local);
    public Page<Produto> findAllByLocalOrderByNomeAsc(Local local, Pageable pageable);
}
