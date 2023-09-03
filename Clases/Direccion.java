package Clases;

public class Direccion {
    public String calle;
    public int noCalle;
    public String nomenclatura;
    public String barrio;
    public String ciudad;


    public Direccion(String calle, int noCalle, String nomenclatura, String barrio, String ciudad) {
        this.calle = calle;
        this.noCalle = noCalle;
        this.nomenclatura = nomenclatura;
        this.barrio = barrio;
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public int getNoCalle() {
        return noCalle;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getCiudad() {
        return ciudad;
    }


    
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNoCalle(int noCalle) {
        this.noCalle = noCalle;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}