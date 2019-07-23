package pe.com.targethr.authserver.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EBUSUARIOS")
public class UsuarioEntityBCK {

    @Id
    @Column(name = "EBCODUSU")
    private Long codigo;

    @Column(name = "EBDESUSU")
    private String username;

    @Column(name = "EBPASSW")
    private String password;

    @Column(name = "EBFLGEST")
    private String estado;

    /**
     * @return the codigo
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}