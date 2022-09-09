package com.butraining.travelcompany.weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController //allows to handle API requests
public class WeatherResource {
	
	@Autowired
	private WeatherService weatherService;
	
	
	 @RequestMapping(value="/weather",method=RequestMethod.GET)
     @ResponseStatus(HttpStatus.OK)   //200 
 	public Iterable<Weather> getAllRecords()
 	{
    	 return weatherService.getAllRecords();
 	}
	
   
     @RequestMapping(value="/weather/{weatherid}",method=RequestMethod.GET)
     @ResponseStatus(HttpStatus.OK) //200
 	public Weather getRecordById(@PathVariable(value="weatherid") long id)
 	{
   
    	 return weatherService.getRecordById(id);
    	 
 	}
     
     
     @RequestMapping(value="/weather",method=RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED) //201
 	public Weather saveRecord(@Validated @RequestBody Weather weather)
 	{
    	 return weatherService.saveOrUpdate(weather);
 	}
     
     
     
     @RequestMapping(value="/weather/{weatherid}",method=RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.NO_CONTENT) // 204
 	public void deleteRecordById(@PathVariable(value="weatherid") long id)
 	{
    	 weatherService.deleteRecordById(id);
 	}
 		
 
     

}
