package bt.com.veggie.burgers.estoque.entity;

import java.io.Serializable;
import java.util.Objects;

public class HistoricoPK implements Serializable {
    private int historicoId;
    private int produtoId;

    public HistoricoPK(int historicoId, int produtoId) {
        this.historicoId = historicoId;
        this.produtoId = produtoId;
    }

    public HistoricoPK() {
    }

    public int getHistoricoId() {
        return historicoId;
    }

    public void setHistoricoId(int historicoId) {
        this.historicoId = historicoId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoPK that = (HistoricoPK) o;
        return historicoId == that.historicoId &&
                produtoId == that.produtoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(historicoId, produtoId);
    }
}
