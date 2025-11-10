package iuh.fit.se.repositories;

import iuh.fit.se.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(collectionResourceRel = "address", path = "address", exported = false)
public interface AddressRepository extends JpaRepository<Address, Integer>{
}
