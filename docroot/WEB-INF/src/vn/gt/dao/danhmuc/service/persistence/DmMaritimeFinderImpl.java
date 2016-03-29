package vn.gt.dao.danhmuc.service.persistence;

import java.util.List;

import vn.gt.dao.danhmuc.model.DmMaritime;
import vn.gt.dao.danhmuc.model.impl.DmMaritimeImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class DmMaritimeFinderImpl extends BasePersistenceImpl<DmMaritime> implements DmMaritimeFinder {
	private Log log = LogFactoryUtil.getLog(DmMaritimeFinderImpl.class);

	public List<DmMaritime> getAll() throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT * FROM dm_maritime ");
			query.append("ORDER BY CONVERT(CityCode USING utf8) COLLATE utf8_polish_ci");
			
			log.debug("===getAll===" + query.toString());
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity("DmMaritime", DmMaritimeImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			// qPos.add(type);
			
			return (List<DmMaritime>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

}
