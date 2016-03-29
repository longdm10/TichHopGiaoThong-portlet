package vn.gt.dao.danhmuc.service.persistence;

import java.util.List;

import vn.gt.dao.danhmuc.model.DmPortWharf;
import vn.gt.dao.danhmuc.model.impl.DmPortWharfImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class DmPortWharfFinderImpl extends BasePersistenceImpl<DmPortWharf> implements DmPortWharfFinder {
	
	private static Log _log = LogFactoryUtil.getLog(DmPortWharfFinderImpl.class);

	public List<DmPortWharf> findByPortRegionCodeAndPortHarbourCodeOrNullOrderPortCode(String portRegionCode, String portHarbourCode, boolean ascOrdesc) throws SystemException {
		Session session = null;
		try {
			
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT * FROM dm_port_wharf WHERE 1= 1   ");
			
			if (Validator.isNotNull(portRegionCode) && portRegionCode.trim().length() > 0 ) {
				query.append(" and PortRegionCode = '" + portRegionCode + "'");
			}
			
			if (Validator.isNotNull(portHarbourCode) && portHarbourCode.trim().length() > 0 ) {
				query.append(" and (PortHarbourCode is null or PortHarbourCode = '"+portHarbourCode+"')");
			}
			
			if (ascOrdesc == true) {
				query.append(" order by PortCode asc");
			} else {
				query.append(" order by PortCode desc");
			}
			
			String sql = query.toString();
			
			_log.debug("========findByPortHarbourCodeOrNullOrderPortCode======" + query.toString());
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("DmPortWharf", DmPortWharfImpl.class);
			
			// execute the query and return a list from the db
			return (List<DmPortWharf>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<DmPortWharf> findByPortHarbourCodeOrNull(String portHarbourCode, boolean ascOrdesc) throws SystemException {
		Session session = null;
		try {
			
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT * FROM dm_port_wharf WHERE 1 = 1 ");
			
			if (Validator.isNotNull(portHarbourCode) && portHarbourCode.trim().length() > 0) {
				query.append(" and (PortHarbourCode is null or PortHarbourCode = '" + portHarbourCode + "')");
			}
			
			if (ascOrdesc == true) {
				query.append(" order by PortCode asc");
			} else {
				query.append(" order by PortCode desc");
			}
			
			String sql = query.toString();
			
			_log.debug("========findByPortHarbourCodeOrNullOrderPortCode======" + query.toString());
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("DmPortWharf", DmPortWharfImpl.class);
			
			// execute the query and return a list from the db
			return (List<DmPortWharf>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<DmPortWharf> findByPortRegionCodeOrderPortCode(String portRegionCode, boolean ascOrdesc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT * FROM dm_port_wharf WHERE 1 = 1 ");
			
			if (Validator.isNotNull(portRegionCode) && portRegionCode.trim().length() > 0 ) {
				query.append("and PortRegionCode = '" + portRegionCode + "'");
			}
			
			if (ascOrdesc == true) {
				query.append(" order by PortCode asc");
			} else {
				query.append(" order by PortCode desc");
			}
			
			String sql = query.toString();
			
			_log.debug("========findByPortRegionCodeOrderPortCode======" + query.toString());
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("DmPortWharf", DmPortWharfImpl.class);
			
			// execute the query and return a list from the db
			return (List<DmPortWharf>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
}
