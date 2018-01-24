package org.guerillamac.endpoint;

import org.guerillamac.data.PasswordLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WifiPasswordLocationEndpoint {

//	@Autowired
//	private PasswordLocationRepository repository;

	@GetMapping("/{location}")
	public String getWifiPassword(@PathVariable("location")String location){
		//TODO maybe return type should be changed to Model/ModelAttr

//		return repository.findByLocation(location).toString();
	return "";
	}



}
