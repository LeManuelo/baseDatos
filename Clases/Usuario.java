package Clases;

public class Usuario implements Comparable <Usuario> {
    private long id;
    private String nombre;
    private Fecha fechaNac;
    private String ciudadNac;
    private Direccion dir;
    private long tel;
    private String email;


    public Usuario(long id, String nombre, Fecha fechaNac, String ciudadNac, Direccion dir, long tel, String email) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.ciudadNac = ciudadNac;
        this.dir = dir;
        this.tel = tel;
        this.email = email;
    }


    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaNac() {
        return fechaNac;
    }

    public String getCiudadNac() {
        return ciudadNac;
    }

    public Direccion getDir() {
        return dir;
    }

    public long getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }


    
    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setCiudadNac(String ciudadNac) {
        this.ciudadNac = ciudadNac;
    }

    public void setDir(Direccion dir) {
        this.dir = dir;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Usuario otroUsuario) {
        return Long.compare(this.id, otroUsuario.id);
    }
    
}