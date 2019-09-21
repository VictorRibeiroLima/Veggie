package bt.com.veggie.burgers.estoque.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.naming.Name;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "TB_VG_HISTORICO")
@IdClass(HistoricoPK.class)
public class Historico {
    @Id
    @SequenceGenerator(name = "historico",sequenceName = "SQ_TB_HISTORICO",allocationSize = 1)
    @GeneratedValue(generator = "historico",strategy = GenerationType.SEQUENCE)
    @Column(name = "historico_id")
    private int historicoId;
    @Id
    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;
    @Column(name="historico_vl_alterado",nullable = false)
    private int valorAlterado;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "historico_dt_modificacao")
    private Calendar dataModificacao;
    @Column(name="historico_hr_modificacao")
    @Temporal(TemporalType.TIME)
    private Date horaModificacao;
    @Enumerated(EnumType.STRING)
    @Column(name="historico_tipo")
    private Tipo tipo;

    public Historico() {
    }

    public Historico(Produto produto, int valorAlterado, Calendar dataModificacao, Date horaModificacao, Tipo tipo) {
        this.produto = produto;
        this.valorAlterado = valorAlterado;
        this.dataModificacao = dataModificacao;
        this.horaModificacao = horaModificacao;
        this.tipo = tipo;
    }

    public int getHistoricoId() {
        return historicoId;
    }

    public void setHistoricoId(int historicoId) {
        this.historicoId = historicoId;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getValorAlterado() {
        return valorAlterado;
    }

    public void setValorAlterado(int valorAlterado) {
        this.valorAlterado = valorAlterado;
    }

    public Calendar getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Calendar dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Date getHoraModificacao() {
        return horaModificacao;
    }

    public void setHoraModificacao(Date horaModificacao) {
        this.horaModificacao = horaModificacao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
