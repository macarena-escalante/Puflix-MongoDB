package ar.com.ada.api.puflix_mongo.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.puflix_mongo.entities.Usuario;



/**
 * UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {
    Usuario findBy_id(ObjectId _id);    
    Usuario findByUserName(String userName);
    Usuario findByUserEmail(String email);
}
