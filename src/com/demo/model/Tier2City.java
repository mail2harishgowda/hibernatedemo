package com.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

/*@DiscriminatorValue("SmallTown")
*/
public class Tier2City extends City {
	  private String shops;

	public String getShops() {
		return shops;
	}

	public void setShops(String shops) {
		this.shops = shops;
	}

}
