package ar.com.ada.api.puflix_mongo.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import ar.com.ada.api.puflix_mongo.entities.Peli;

/**
 * PeliRepository
 */
public interface PeliRepository extends MongoRepository<Peli, Integer>{

    Peli findBy_id(ObjectId _id);  
    Peli findByNombre(String nombre);
    Peli findByGenero(String genero);
    
}