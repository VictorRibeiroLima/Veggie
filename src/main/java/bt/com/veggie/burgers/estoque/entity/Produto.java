package bt.com.veggie.burgers.estoque.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_VB_PRODUTO")
@SequenceGenerator(name="produto",sequenceName = "SQ_TB_PRODUTO",allocationSize = 1)
public class Produto{
    @Id
    @GeneratedValue(generator = "produto",strategy = GenerationType.SEQUENCE)
    private int produtoId;
    @Column(name = "produto_nome",nullable = false)
    private String nome;
    @Column(name = "produto_qtd",nullable = false)
    private int quantidade;
    @Column(name="produto_vldd")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date validade;
    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;
    @OneToMany(mappedBy = "produto",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Historico> historicos = new ArrayList<Historico>();

    public Produto(String nome, int quantidade, Date validade, Local local, List<Historico> historicos) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.validade = validade;
        this.local = local;
        this.historicos = historicos;
    }

    public Produto() {
    }

    public Produto(int quantidade, Date validade, Local local, List<Historico> historicos) {
        this.quantidade = quantidade;
        this.validade = validade;
        this.local = local;
        this.historicos = historicos;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }
    public void addHistorico(Historico historico){
        historico.setProduto(this);
        historicos.add(historico);
    }
    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
