package com.tour.dao;

import com.tour.model.TAssistantanswers;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAssistantanswers entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tour.model.TAssistantanswers
 * @author MyEclipse Persistence Tools
 */

@Repository("tAssistantanswersDAO")
public class TAssistantanswersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TAssistantanswersDAO.class);
	// property constants
	public static final String QUESTION_ID = "questionId";
	public static final String STATE = "state";
	public static final String FROMUSERSCORE = "fromuserscore";
	public static final String TOUSERSCORE = "touserscore";
	public static final String ANSWER = "answer";

	public void save(TAssistantanswers transientInstance) {
		log.debug("saving TAssistantanswers instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TAssistantanswers persistentInstance) {
		log.debug("deleting TAssistantanswers instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TAssistantanswers findById(Long id) {
		log.debug("getting TAssistantanswers instance with id: " + id);
		try {
			TAssistantanswers instance = (TAssistantanswers) getSession().get(
					"com.tour.model.TAssistantanswers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TAssistantanswers instance) {
		log.debug("finding TAssistantanswers instance by example");
		try {
			List results = getSession()
					.createCriteria("com.tour.model.TAssistantanswers")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TAssistantanswers instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TAssistantanswers as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByQuestionId(Object questionId) {
		return findByProperty(QUESTION_ID, questionId);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByFromuserscore(Object fromuserscore) {
		return findByProperty(FROMUSERSCORE, fromuserscore);
	}

	public List findByTouserscore(Object touserscore) {
		return findByProperty(TOUSERSCORE, touserscore);
	}

	public List findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	public List findAll() {
		log.debug("finding all TAssistantanswers instances");
		try {
			String queryString = "from TAssistantanswers";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TAssistantanswers merge(TAssistantanswers detachedInstance) {
		log.debug("merging TAssistantanswers instance");
		try {
			TAssistantanswers result = (TAssistantanswers) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TAssistantanswers instance) {
		log.debug("attaching dirty TAssistantanswers instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TAssistantanswers instance) {
		log.debug("attaching clean TAssistantanswers instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
