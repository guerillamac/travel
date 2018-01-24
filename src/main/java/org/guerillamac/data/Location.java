package org.guerillamac.data;

import javax.persistence.Entity;

@Entity
public class Location {


	private WifiPassword password;

	public Location(WifiPassword password) {
		this.password = password;
	}

	public WifiPassword getPassword() {
		return password;
	}

}
