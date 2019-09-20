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

}
