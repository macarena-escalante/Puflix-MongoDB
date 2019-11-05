package ar.com.ada.api.puflix_mongo.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.puflix_mongo.entities.Episodio;
import ar.com.ada.api.puflix_mongo.entities.Serie;
import ar.com.ada.api.puflix_mongo.entities.Temporada;
import ar.com.ada.api.puflix_mongo.repo.SerieRepository;

/**
 * SerieService
 */
@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepo;

    @Autowired
    SerieService serieService;

    public Serie buscarPorId(ObjectId _id) {

        return serieRepo.findBy_id(_id);

    }

    public Serie buscarPorNombre(String nombre) {

        return serieRepo.findByNombre(nombre);

    }

    public Serie buscarPorGenero(String genero) {

        return serieRepo.findByGenero(genero);

    }

    public void save(Serie s) {
        serieRepo.save(s);
    }

    public List<Serie> getSeries() {

        return serieRepo.findAll();
    }

    public void agregarTemporada (String idSerie, Temporada temporada){

        Serie s = serieService.buscarPorId(new ObjectId (idSerie));

        s.temporadas.add(temporada);
        serieService.save(s);
        
    }

    public void agregarEpisodio (Episodio episodio, String idSerie, int nroTemp){
        
        Serie s = serieService.buscarPorId(new ObjectId (idSerie));
        Temporada t = s.getTemporada(nroTemp);
        t.episodios.add(episodio);
        serieService.save(s);
    }



}