package com.amdocs.ToursTravels.ToursTravels.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.ToursTravels.ToursTravels.DAO.ToursDAO;
import com.amdocs.ToursTravels.ToursTravels.Entity.Tours;

@RestController
@RequestMapping("/api")

public class ToursController {
	
	private ToursDAO toursDAO;
	
	public ToursController(ToursDAO theToursDAO)
	{
		this.toursDAO = theToursDAO;
	}
	
	@GetMapping("/tours")
	public List<Tours> findAll()
	{
		List<Tours> tour = toursDAO.findAll();
		return tour;
	}

	@GetMapping("/tours/{tourID}")
	public Tours getTour(@PathVariable int tourID) throws TourNotFoundException
	{
		Tours tour = toursDAO.getTour(tourID);
		if(tour == null) {
			throw new TourNotFoundException("Tour Not Found => " + tourID);
		}
		return tour;
	}
	
	@PostMapping("/tours")
	public Tours addTour(@RequestBody Tours theTour)
	{
		Tours tour = toursDAO.addTour(theTour);
		return tour;
	}
	
	@PutMapping("/tours")
	public Tours updateTour(@RequestBody Tours theTour)
	{
		Tours tour = toursDAO.updateTour(theTour);
		return tour;
	}
	
	@DeleteMapping("/tours/{tourID}")
	public void deleteTour(@PathVariable int tourID)
	{
		toursDAO.deleteTour(tourID);
	}
}
