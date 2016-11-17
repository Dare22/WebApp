package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.Users;

@Transactional
@Component("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	public void save(Users users) {

		session().save(users);

	}

	public void update(Users users) {

		session().update(users);

	}

	public void delete(int id) {

		Users users = getUsers(id);

		if (users != null)
			session().delete(users);

	}

	public void resetAutoIncrement() { // this method reset the id column 

		@SuppressWarnings({ "rawtypes", "deprecation" })
		Query queryDrop = session().createSQLQuery("ALTER TABLE users DROP id"); //delete id
		queryDrop.executeUpdate();

		@SuppressWarnings({ "deprecation", "rawtypes" })
		Query queryCreate = session().createSQLQuery(
				"ALTER TABLE users ADD  id INT(100) NOT NULL AUTO_INCREMENT FIRST ,ADD PRIMARY KEY (id)"); //create id
		queryCreate.executeUpdate();

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Users> readUsers() {

		return session().createQuery("from Users").list();

	}

	public Users getUsers(int id) {

		Users users = (Users) session().get(Users.class, id);

		return users;

	}

	public boolean exsist(String username) {

		@SuppressWarnings("deprecation")
		Criteria crit = session().createCriteria(Users.class);

		crit.add(Restrictions.eq("username", username));

		Users users = (Users) crit.uniqueResult();

		return users != null;

	}

}
