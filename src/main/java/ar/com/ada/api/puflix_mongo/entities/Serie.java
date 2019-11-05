package ar.com.ada.api.puflix_mongo.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;

import ar.com.ada.api.puflix_mongo.repo.TemporadaRepository;


/**
 * Serie
 */
@Document(collection = "Series")
public class Serie extends Contenido {

    @Autowired
    TemporadaRepository temporadaRepo;

    public List<Temporada> temporadas = new ArrayList<Temporada>();
    
    public List<Temporada> getTemporadas() {

        return temporadaRepo.findAll();
    }


    public Temporada getTemporada(int nro)
    {
        //Recorrer cada temporada
        //Si el nro de temporada del ciclo es igual a "nro"
        //Devolver esa temporada
        
        for (Temporada tempo : this.temporadas) {
            if(tempo.numeroTemporada == nro)
            {
                return tempo;
            }
            
        }

        return null;
    }
}