package ar.com.ada.api.puflix_mongo.services;

import java.util.HashMap;
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

        s.getTemporadas().add(temporada);
        serieService.save(s);
        
    }

    public void agregarEpisodio (Episodio episodio, String idSerie, int nroTemp){
        
        Serie s = serieService.buscarPorId(new ObjectId (idSerie));
        Temporada t = s.getTemporada(nroTemp);
        t.episodios.add(episodio);
        serieService.save(s);
    }

    public enum SerieValidationType {

        SERIE_OK, 
        TEMPORADAS_NULA, 
        TEMPORADAS_VACIA, 
        TEMPORADA_DUPLICADA, 
        TEMPORADA_INVALIDA,

        SERIE_DATOS_INVALIDOS 
        
    }
/** Se verifica si el nombre de la serie NO está nulo
 * El año no es 0
 * La temporada no está nula ni vacía
 * 
 * @param serie
 * @return
 */
    public SerieValidationType verificarSerie(Serie serie) {

        if (serie.getNombre() == null)
            return SerieValidationType.SERIE_DATOS_INVALIDOS;

        if (serie.getAño() <= 0)
            return SerieValidationType.SERIE_DATOS_INVALIDOS;

        if (serie.getTemporadas() == null)
            return SerieValidationType.TEMPORADAS_NULA;
        if (serie.getTemporadas().size() == 0)
            return SerieValidationType.TEMPORADAS_VACIA;

        //Armo un hashmap para ver si la temporada esta duplicada
        HashMap<Integer, Temporada> unicasTemps = new HashMap<>();

        for (Temporada t : serie.getTemporadas()) {
            if (unicasTemps.containsKey(new Integer(t.getNumeroTemporada())))
                return SerieValidationType.TEMPORADA_DUPLICADA;
            if (t.getEpisodios().size() == 0)
                return SerieValidationType.TEMPORADA_INVALIDA;
        
        unicasTemps.put(new Integer(t.getNumeroTemporada()), t);
        
            }

        return SerieValidationType.SERIE_OK;
    }





}