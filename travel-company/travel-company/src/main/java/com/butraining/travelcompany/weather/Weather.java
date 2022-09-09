package com.butraining.travelcompany.weather;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Weather")
public class Weather {
	
	@Id
	@GeneratedValue
	private long id;

	@CreationTimestamp
	private LocalDate date;

	@JsonProperty("latitude")
	private double latitude;
	
    @JsonProperty("longitude")
	private double longitude;

	private String city;

	private String state;

	private double temperature;
  

	
	public Weather()
	{
		
	}
	

	public Weather(long id, LocalDate date, double latitude, double longitude, String city, String state, double temperature) {
		super();
		this.id = id;
		this.date = date;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
		this.temperature = temperature;

	}
  
	

	public long getId() {
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}


	@JsonProperty("latitude")
	public double getLat() {
		return latitude;
	}

    @JsonProperty("longitude")
	public double getLon() {
		return longitude;
	}


	public String getCity() {
		return city;
	}


	public String getState() {
		return state;
	}


	public double getTemperature() {
		return temperature;
	}



	@Override
	public String toString() {
		return "Weather [id=" + id + ", date=" + date + ", latitude=" + latitude + ", longitude=" + longitude + ", city=" + city + ", state="
				+ state + ", temperature=" + temperature + "]";
	}
	
	


	
	
	
	

	
}
