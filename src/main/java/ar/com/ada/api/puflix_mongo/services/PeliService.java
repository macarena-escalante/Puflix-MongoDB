package ar.com.ada.api.puflix_mongo.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.puflix_mongo.entities.Peli;
import ar.com.ada.api.puflix_mongo.repo.PeliRepository;

/**
 * PeliService
 */
@Service
public class PeliService {

    @Autowired
    PeliService peliService;

    @Autowired
    PeliRepository peliRepository;

    public Peli buscarPorId(ObjectId _id) {

        return peliRepository.findBy_id(_id);

    }

    public Peli buscarPorNombre(String nombre) {

        return peliRepository.findByNombre(nombre);

    }

    public Peli buscarPorGenero(String genero) {

        return peliRepository.findByGenero(genero);

    }

    public void save(Peli p) {
        peliRepository.save(p);
    }

    public void crearPeli (Peli p){

        peliService.save(p);
    }

    public List<Peli> getPelis() {

        return peliRepository.findAll();
    }


}