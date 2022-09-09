package com.butraining.travelcompany;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.butraining.travelcompany.weather.Weather;
import com.butraining.travelcompany.weather.WeatherRestRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WeatherTests {
	
	@Autowired
	private WeatherRestRepository repository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testAddRecord() {
		Weather weather=new Weather(1,LocalDate.now(),66.2345,25.7654,"Hyderabad","TS",25.6);
		Weather savedRecord = repository.save(weather);
	   
		 assertNotNull(savedRecord);	 
	
	}
	
	@Test
	@Order(2)
	public void testGetRecords()
	{
		Iterable<Weather> foundRecords = repository.findAll();
		assertThat(foundRecords).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	@Order(3)
	public void testGetRecordById()
	{
		long id=1;
		Weather weather=repository.findById(id).get();
		assertThat(weather.getId()).isEqualTo(id);
		
	}
	
	
	@Test
	@Rollback(false)
	@Order(4)
	public void testDeleteById()
	{
		 long id=1;
		 boolean present1=repository.findById(id).isPresent();
		 repository.deleteById(id);
		 boolean present2=repository.findById(id).isPresent();
		
		 assertTrue(present1);
		 assertFalse(present2);
	}

}
