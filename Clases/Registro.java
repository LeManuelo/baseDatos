package Clases;
import java.util.*;
import java.io.*;  

public class Registro {
    private int noRegistros = 0;
    Usuario[] registros = new Usuario[5];

    private void ordenarPorId() {
        for (int i = 1; i < noRegistros; i++) {
            Usuario usuarioActual = registros[i];
            int j = i - 1;

            while (j >= 0 && registros[j].getId() > usuarioActual.getId()) {
                registros[j + 1] = registros[j];
                j--;
            }

            registros[j + 1] = usuarioActual;
        }
    }

    public boolean agregar(Usuario u){

        boolean status = false;

        if(noRegistros < 5) {
            for(int i = 0;i<noRegistros;i++){
                if(u.getId() == registros[i].getId()){
                    status = false;
                    break;
                }else{
                    status = true;
                }
            }
            if(status == true){
                registros[noRegistros] = u;
                noRegistros++;
                ordenarPorId();
                status = true;
                toFile();
            }
        }
        return status;
    }

    public Usuario eliminar(long id){
        Usuario usuario = null;
        int pos = buscarPosicion(id);
        if(pos!=-1){
            usuario = registros[pos];
            registros[pos] = null;
            reorganizarArreglo();
            noRegistros--;
            System.out.println(pos);
            toFile();
        }
        return usuario;
    }

    private void reorganizarArreglo() {
        Usuario[] nuevoArreglo = new Usuario[registros.length];
        int nuevoIndice = 0;
    
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] != null) {
                nuevoArreglo[nuevoIndice] = registros[i];
                nuevoIndice++;
            }
        }
        registros = nuevoArreglo;
    }

    public Usuario buscarUsuario(long id) {
        for (int i = 0; i < noRegistros; i++) {
            if (registros[i].getId() == id) {
                return registros[i];
            }
        }
        return null;
    }

    public int buscarPosicion(long id){
        int pos = -1;
        for(int i = 0;i<noRegistros;i++){
            if(id == registros[i].getId()){
                pos = i;
            }
        }
        return pos;
    }

    public void toFile(){
                String texto = "";
                Arrays.sort(registros, 0, noRegistros);
                for(int i =0;i< noRegistros;i++){
                        if(i == 0){
                            texto = registros[i].getId()+"-"+registros[i].getNombre()+"-"+registros[i].getFechaNac().getDd()+"-"+registros[i].getFechaNac().getMm()+"-"+registros[i].getFechaNac().getAa()+"-"+registros[i].getCiudadNac()+"-"+registros[i].getDir().getCalle()+"-"+registros[i].getDir().getNoCalle()+"-"+registros[i].getDir().getNomenclatura()+"-"+registros[i].getDir().getBarrio()+"-"+registros[i].getDir().getCiudad()+"-"+registros[i].getTel()+"-"+registros[i].getEmail();
                        }else{
                            texto = texto+"\n"+registros[i].getId()+"-"+registros[i].getNombre()+"-"+registros[i].getFechaNac().getDd()+"-"+registros[i].getFechaNac().getMm()+"-"+registros[i].getFechaNac().getAa()+"-"+registros[i].getCiudadNac()+"-"+registros[i].getDir().getCalle()+"-"+registros[i].getDir().getNoCalle()+"-"+registros[i].getDir().getNomenclatura()+"-"+registros[i].getDir().getBarrio()+"-"+registros[i].getDir().getCiudad()+"-"+registros[i].getTel()+"-"+registros[i].getEmail(); 
                        }
                    }
                try {
                    FileWriter registro = new FileWriter("registro.txt");
                    registro.write(texto);
                    registro.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
    }

    public void importar(){
        try{
            FileReader baseDatos = new FileReader("registro.txt");
            BufferedReader lector = new BufferedReader(baseDatos);
            
            if(baseDatos.ready()){
                String dataAux;
                while((dataAux = lector.readLine())!= null){
                String data[] = dataAux.split("-");
                
                Fecha fechaNac = new Fecha(Integer.valueOf(data[2]),Integer.valueOf(data[3]) , Integer.valueOf(data[4]));
                Direccion dir = new Direccion(data[6], Integer.valueOf(data[7]), data[8], data[9], data[10]);
                Usuario usuario = new Usuario(Long.parseLong(data[0]),data[1],fechaNac,data[5],dir,Long.parseLong(data[11]),data[12]);

                registros[noRegistros] = usuario;
                noRegistros++;
                }                
            }
            toFile();
            lector.close();            
        }catch(Exception e){
            try {
                File baseDatos = new File("registro.txt");
                baseDatos.createNewFile();
              } catch (IOException x) {
                System.out.println("An error occurred.");
                x.printStackTrace();
              }
        }
    }
}
