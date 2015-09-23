package com.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

/*@DiscriminatorValue("HiFi")
*/
public class Tier1City extends City {
	private String mall;

	public String getMall() {
		return mall;
	}

	public void setMall(String mall) {
		this.mall = mall;
	}

}
