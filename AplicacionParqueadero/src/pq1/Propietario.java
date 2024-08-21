package pq1;

import java.io.Serializable;

public class Propietario implements Serializable{
      private static final long serialVersionUID = 1L;
    public String nombre;
    public String identificaion;

    public String obtenerNombre() {
        return nombre;
    }

    public void modificarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerIdentificaion() {
        return identificaion;
    }

    public void modificarIdentificaion(String identificaion) {
        this.identificaion = identificaion;
    }
    
    
    
}
