package bt.com.veggie.burgers.estoque.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TB_VB_LOCAL")
@SequenceGenerator(name="local",sequenceName = "SQ_TB_LOCAL",allocationSize = 1)
public class Local {
    @Id
    @Column(name="local_id")
    @GeneratedValue(generator = "local",strategy = GenerationType.SEQUENCE)
    private int localId;
    @Column(name="local_nome",nullable = false)
    private String nome;
    @OneToMany(mappedBy = "local",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Produto> produtos=new ArrayList<Produto>();

    public Local(String nome, List<Produto> produtos) {
        this.nome = nome;
        this.produtos = produtos;
    }

    public Local() {
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    public void addProduto(Produto produto){
        produto.setLocal(this);
        produtos.add(produto);
    }
}
