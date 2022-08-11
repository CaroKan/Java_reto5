
package model.vo;

public class LideresVo {
   private Integer idLider;
   private String nombre;
   private String primerApellido;
   private String residencia;

    public LideresVo(Integer idLider, String nombre, String primerApellido, String residencia) {
        this.idLider = idLider;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.residencia = residencia;
    }

    public int getIdLider() {
        return this.idLider;
    }

    public void setIdLider(Integer idLider) {
        this.idLider = idLider;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getResidencia() {
        return this.residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

   
   
}
