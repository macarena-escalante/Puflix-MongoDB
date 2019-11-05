package ar.com.ada.api.puflix_mongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.puflix_mongo.entities.Peli;
import ar.com.ada.api.puflix_mongo.models.response.RegistrationResponse;
import ar.com.ada.api.puflix_mongo.services.PeliService;

/**
 * PeliController
 */
@RestController
public class PeliController {

    @Autowired
    PeliService peliService;

    @PostMapping ("/peliculas")
    public RegistrationResponse postNewPelicula (@RequestBody Peli p){

        RegistrationResponse peli = new RegistrationResponse();
        peliService.crearPeli(p);

        peli.isOk = true;
        peli.message = "Registraste una peli con exitoooo";
        return peli;
    }

    @GetMapping("/peliculas")
    public List<Peli> getPelis()
    {
        List<Peli> pelis = peliService.getPelis();
        
        return pelis;
    }

    

}