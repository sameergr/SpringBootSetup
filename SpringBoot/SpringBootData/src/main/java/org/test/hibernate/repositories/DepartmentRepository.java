package org.test.hibernate.repositories;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("departmentRepository")
public class DepartmentRepository implements CrudRepository<Object, Long>{

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public <S> S save(S entity) {
		sessionFactory.getCurrentSession().persist(entity);
		return entity;
	}

	@Override
	public <S> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Object> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Object> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Object> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	


	
}
