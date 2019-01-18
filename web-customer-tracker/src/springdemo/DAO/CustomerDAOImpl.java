package springdemo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(){
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create Query & sorting
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//get result from query
		List<Customer> customers = theQuery.getResultList();
		//return result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
		
		// in Hibernate session.save(): insert new
		// session.update():  update
		// So use saveOrUpdate:  if(id) empty, insert else update
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theq = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theq.setParameter("customerId", theId);
		
		theq.executeUpdate();
		//return null;
	}
}
