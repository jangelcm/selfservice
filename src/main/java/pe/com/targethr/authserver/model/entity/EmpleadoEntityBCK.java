package pe.com.targethr.authserver.model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import pe.com.targethr.authserver.model.entity.pk.EmpleadoId;

@Entity
@Table(name = "HR_EMPLEADO")
public class EmpleadoEntityBCK {

    @EmbeddedId
    private EmpleadoId id;

    @Column(name = "EMPNOMBRE")
    private String nombre;

    @Column(name = "EMPAPATERN")
    private String apellidoPaterno;

    @Column(name = "EMPAMATERN")
    private String apellidoMaterno;

    @Column(name = "EMPFLGEST")
    private String estado;

    @Column(name = "EMPEMAIL")
    private String email;

    @Column(name = "EMPCODTRAJEF")
    private String codigoTrabajadorJefe;

    @Column(name = "EMPNROPOS")
    private String nivel;

    /**
     * @return the id
     */
    public EmpleadoId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(EmpleadoId id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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

    /**
     * @return the codigoTrabajadorJefe
     */
    public String getCodigoTrabajadorJefe() {
        return codigoTrabajadorJefe;
    }

    /**
     * @param codigoTrabajadorJefe the codigoTrabajadorJefe to set
     */
    public void setCodigoTrabajadorJefe(String codigoTrabajadorJefe) {
        this.codigoTrabajadorJefe = codigoTrabajadorJefe;
    }

    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}