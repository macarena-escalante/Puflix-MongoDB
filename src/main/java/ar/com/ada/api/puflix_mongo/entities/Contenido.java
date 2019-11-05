package ar.com.ada.api.puflix_mongo.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Contenido
 */
public class Contenido {

    //Declarar variables de instancia: accesor tipo NombreVariable:

    @Id
    public ObjectId _id;
    
    public String nombre;
    public String genero;
    public int año;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public ObjectId get_id() {
        return _id;
    }


}