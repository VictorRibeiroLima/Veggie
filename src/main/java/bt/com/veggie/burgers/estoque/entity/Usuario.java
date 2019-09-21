package bt.com.veggie.burgers.estoque.entity;

import javax.persistence.*;

@Entity
@Table(name="TB_VB_USUARIO")
@SequenceGenerator(name="usuario",sequenceName = "SQ_TB_USUARIO",allocationSize = 1)
public class Usuario {
    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(generator = "usuario",strategy = GenerationType.SEQUENCE)
    private int usuarioId;
    @Column(name = "usuario_login",unique = true,nullable = false)
    private String login;
    @Column(name = "usuario_senha",nullable = false)
    private String senha;
    @Column(name = "usuario_autorizado",nullable = false)
    private boolean autorizado;

    public Usuario() {
    }

    public Usuario(int usuarioId, String login, String senha, boolean autorizado) {
        this.usuarioId = usuarioId;
        this.login = login;
        this.senha = senha;
        this.autorizado = autorizado;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }
}
