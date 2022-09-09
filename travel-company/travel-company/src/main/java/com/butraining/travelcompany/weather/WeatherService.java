package com.butraining.travelcompany.weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.butraining.travelcompany.exceptions.InvalidIdException;


@Service  // provides business logic
public class WeatherService{
	
	@Autowired
	private WeatherRestRepository repository;

	
	public Weather saveOrUpdate(Weather weather2)
	{
		return repository.save(weather2);
	}
	
	
	public Weather getRecordById(Long id)
	{  
		
		if(!repository.existsById(id))
	   {
		throw new InvalidIdException("Record does not exist");
	   }
		
		
		return repository.findById(id).get();
		
	}


	public void deleteRecordById(long id) {
		if(!repository.existsById(id))
		{
			throw new InvalidIdException("Record does not exist");
		}
		
		repository.deleteById(id);
	}


	public Iterable<Weather> getAllRecords() {
		
		return repository.findAll();
	}
	




}




