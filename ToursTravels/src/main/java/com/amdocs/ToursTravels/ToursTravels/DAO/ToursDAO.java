package com.amdocs.ToursTravels.ToursTravels.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.amdocs.ToursTravels.ToursTravels.Entity.Tours;

@Repository
public class ToursDAO {
	private EntityManager entityManager;
	
	public ToursDAO(EntityManager theEntityManager)
	{
		this.entityManager = theEntityManager;
	}
	
	@Transactional()
	public List<Tours> findAll()
	{
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = 
				currentSession.createQuery("from tours",Tours.class);
		List<Tours> tour = theQuery.getResultList();
		
		return tour;
	}
	
	@Transactional()
	public Tours getTour(int theId)
	{
		Session currentSession = entityManager.unwrap(Session.class);
		Tours tour = currentSession.get(Tours.class, theId);
		return tour;
	}
	
	@Transactional()
	public Tours addTour(Tours theTour) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(theTour);
		return theTour;
	}
	
	@Transactional()
	public Tours updateTour(Tours theTour) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.update(theTour);
		return theTour;
	}
	
	@Transactional()
	public void deleteTour(int tourId) {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = 
				currentSession.createQuery("delete from tours where tour_id=:tourId");
		theQuery.setParameter("tourId", tourId);
		theQuery.executeUpdate();
	}
}
