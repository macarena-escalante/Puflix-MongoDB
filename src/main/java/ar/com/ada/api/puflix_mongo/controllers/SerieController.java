package ar.com.ada.api.puflix_mongo.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.puflix_mongo.entities.Episodio;
import ar.com.ada.api.puflix_mongo.entities.Serie;
import ar.com.ada.api.puflix_mongo.entities.Temporada;
import ar.com.ada.api.puflix_mongo.models.response.RegistrationResponse;
import ar.com.ada.api.puflix_mongo.services.SerieService;


/**
 * SerieController
 */
@RestController
public class SerieController {

    @Autowired
    SerieService serieService;


    @PostMapping ("/series")
    public RegistrationResponse postNewSerie (@RequestBody Serie req){

        RegistrationResponse s = new RegistrationResponse();
        serieService.save(req);

        s.isOk = true;
        s.message = "Registraste una serie con exitoooo";
        return s;
        
    }

    @PostMapping ("/series/{id}/temporadas")
    public RegistrationResponse postNewTemporada (@RequestBody Temporada temp, @PathVariable String id){
        
        RegistrationResponse t = new RegistrationResponse();

        serieService.agregarTemporada(id, temp);

        t.isOk = true;
        t.message = "Registraste una temporada con exitoo";
        return t;
    }

    @PostMapping ("/series/{id}/temporadas/{nroTemp}/episodios")
    public RegistrationResponse postNewEpisodio (@RequestBody Episodio ep, @PathVariable String id, @PathVariable int nroTemp){
        
        RegistrationResponse e = new RegistrationResponse();

        
        serieService.agregarEpisodio(ep, id, nroTemp);

        e.isOk = true;
        e.message = "Registraste un episodio con éxito";
        return e;

    }
    
}