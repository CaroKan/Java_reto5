
package model.vo;

public class ProyectosVo {
    private Integer idProyecto;
    private String constructora;
    private Integer numHabitaciones;
    private String ciudad;

    public ProyectosVo(Integer idProyecto, String constructora, Integer numHabitaciones, String ciudad) {
        this.idProyecto = idProyecto;
        this.constructora = constructora;
        this.numHabitaciones = numHabitaciones;
        this.ciudad = ciudad;
    }

    public Integer getIdProyecto() {
        return this.idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getConstructora() {
        return this.constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public Integer getNumHabitaciones() {
        return this.numHabitaciones;
    }

    public void setNumHabitaciones(Integer numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
            
}
