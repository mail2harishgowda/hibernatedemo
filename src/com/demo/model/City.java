package com.demo.model;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
/*@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)*/

@Inheritance(strategy=InheritanceType.JOINED)
/*@DiscriminatorColumn(
		name="CITY_TYPE",
		discriminatorType=DiscriminatorType.STRING		
)*/
/*@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
*/public class City {
	
	@Id @GeneratedValue
	private int cityId;
	private String cityName;
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	

}
