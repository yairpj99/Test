package org.banbajio.backend.EjemploBanBajio.Repository;

import org.banbajio.backend.EjemploBanBajio.Models.BancoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends MongoRepository<BancoModel, String> {

}
