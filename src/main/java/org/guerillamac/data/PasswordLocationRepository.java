package org.guerillamac.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordLocationRepository extends CrudRepository<WifiPassword, Long> {
	public WifiPassword findByLocation(String location);

}
