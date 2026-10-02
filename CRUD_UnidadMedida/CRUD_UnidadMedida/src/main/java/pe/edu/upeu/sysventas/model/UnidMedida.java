package pe.edu.upeu.sysventas.model;


public class UnidMedida {
    private Long idUnidad;
    private String nombreMedida;


    public UnidMedida() {}
    public UnidMedida(Long idUnidad, String nombreMedida) {
        this.idUnidad = idUnidad;
        this.nombreMedida = nombreMedida;
    }
    public Long getIdUnidad() { return idUnidad; }
    public void setIdUnidad(Long idUnidad) { this.idUnidad = idUnidad; }
    public String getNombreMedida() { return nombreMedida; }
    public void setNombreMedida(String nombreMedida) { this.nombreMedida = nombreMedida; }
}
