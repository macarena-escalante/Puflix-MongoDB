package ar.com.ada.api.puflix_mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import ar.com.ada.api.puflix_mongo.entities.Temporada;

/**
 * TemporadaRepository
 */
public interface TemporadaRepository extends MongoRepository<Temporada, Integer>{

    
}