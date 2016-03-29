package vn.gt.dao.noticeandmessage.service.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit;
import vn.gt.dao.noticeandmessage.model.impl.IssuePermissionForTransitImpl;
import vn.gt.utils.ConvertUtil;
import vn.gt.utils.FormatData;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class IssuePermissionForTransitFinderImpl extends BasePersistenceImpl<IssuePermissionForTransit> implements IssuePermissionForTransitFinder {
	
	private Log log = LogFactoryUtil.getLog(IssuePermissionForTransitFinderImpl.class);
	
	public List<IssuePermissionForTransit> findIssuePermissionForTransitInfo(String requestState, String maritimeCode, String portCode,
			String shipName, String callSign, String shipDateFrom, String shipDateTo, int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT iss.* FROM issue_permission_for_transit iss ");
			query.append(" left join temp_document temp ");
			query.append(" on iss.DocumentName = temp.DocumentName ");
			query.append(" and iss.DocumentYear = temp.DocumentYear where 1=1 ");
			
			// RequestState
			if (Validator.isNotNull(requestState) && requestState.trim().length() > 0) {
				query.append(" AND iss.RequestState =" + FormatData.convertToInt(requestState));
			}
			
			// cang vu hang hai
			if (Validator.isNotNull(maritimeCode) && maritimeCode.trim().length() > 0 && !maritimeCode.trim().equalsIgnoreCase("LUA_CHON")) {
				query.append(" AND iss.PortofAuthority = ?");
			}
			log.debug("===query.append===maritimeCode===" + maritimeCode);
			// cang bien
			if (Validator.isNotNull(portCode) && portCode.trim().length() > 0 && !portCode.trim().equalsIgnoreCase("LUA_CHON1")) {
				query.append(" AND temp.portCode = ?");
			}
			log.debug("===query.append===temp.portCode===" + portCode);
			// ten tau
			if (Validator.isNotNull(shipName) && shipName.trim().length() > 0) {
				query.append(" AND iss.NameOfShip like '%" + shipName.trim() + "%' ");
			}
			// Ho hieu
			if (Validator.isNotNull(callSign) && callSign.trim().length() > 0) {
				query.append(" AND temp.CallSign like '%" + callSign.trim() + "%' ");
			}
			// Tu ngay
			if (Validator.isNotNull(shipDateFrom) && shipDateFrom.trim().length() > 0) {
				Date dateFrom = FormatData.parseDateShort3StringToDate(shipDateFrom.trim());
				shipDateFrom = FormatData.parseDateToTring(dateFrom);
				query.append(" AND (iss.CreatedDate >= '" + shipDateFrom + "' OR iss.CreatedDate IS NULL)");
			}
			// Den ngay
			if (Validator.isNotNull(shipDateTo) && shipDateTo.trim().length() > 0) {
				Date dateTo = FormatData.parseDateShort3StringToDate(shipDateTo.trim());
				shipDateTo = FormatData.parseDateToTring(dateTo);
				query.append(" AND (iss.CreatedDate <= '" + shipDateTo + "' OR iss.CreatedDate IS NULL)");
			}
			// query.append(" ORDER BY id DESC");
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity("IssuePermissionForTransit", IssuePermissionForTransitImpl.class);
			log.debug("=========TAU SEARCH --findIssuePermissionForTransitInfo========" + query.toString());
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(maritimeCode) && maritimeCode.trim().length() > 0 && !maritimeCode.trim().equalsIgnoreCase("LUA_CHON")) {
				qPos.add(maritimeCode);
				log.debug("===qPos.add===maritimeCode===" + maritimeCode);
			}
			if (Validator.isNotNull(portCode) && portCode.trim().length() > 0 && !portCode.trim().equalsIgnoreCase("LUA_CHON1")) {
				qPos.add(portCode);
				log.debug("===qPos.add===portCode===" + portCode);
			}
			return (List<IssuePermissionForTransit>) QueryUtil.list(q, getDialect(), start, end);
			
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countIssuePermissionForTransitInfo(String requestState, String maritimeCode, String portCode, String shipName, String callSign,
			String shipDateFrom, String shipDateTo) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT count(*) as total FROM issue_permission_for_transit iss ");
			query.append(" left join temp_document temp ");
			query.append(" on iss.DocumentName = temp.DocumentName ");
			query.append(" and iss.DocumentYear = temp.DocumentYear where 1=1 ");
			// RequestState
			if (Validator.isNotNull(requestState) && requestState.trim().length() > 0) {
				query.append(" AND iss.RequestState =" + FormatData.convertToInt(requestState));
			}
			// cang vu hang hai
			if (Validator.isNotNull(maritimeCode) && maritimeCode.trim().length() > 0 && !maritimeCode.trim().equalsIgnoreCase("LUA_CHON")) {
				query.append(" AND iss.PortofAuthority = ?");
			}
			
			// cang bien
			if (Validator.isNotNull(portCode) && portCode.trim().length() > 0 && !portCode.trim().equalsIgnoreCase("LUA_CHON1")) {
				query.append(" AND temp.portCode = ?");
			}
			// ten tau
			if (Validator.isNotNull(shipName) && shipName.trim().length() > 0) {
				query.append(" AND iss.NameOfShip like '%" + shipName.trim() + "%' ");
			}
			// Ho hieu
			if (Validator.isNotNull(callSign) && callSign.trim().length() > 0) {
				query.append(" AND temp.CallSign like '%" + callSign.trim() + "%' ");
			}
			// Tu ngay
			if (Validator.isNotNull(shipDateFrom) && shipDateFrom.trim().length() > 0) {
				Date dateFrom = FormatData.parseDateShort3StringToDate(shipDateFrom.trim());
				shipDateFrom = FormatData.parseDateToTring(dateFrom);
				query.append(" AND (iss.CreatedDate >= '" + shipDateFrom + "' OR iss.CreatedDate IS NULL)");
			}
			
			// Den ngay
			if (Validator.isNotNull(shipDateTo) && shipDateTo.trim().length() > 0) {
				Date dateTo = FormatData.parseDateShort3StringToDate(shipDateTo.trim());
				shipDateTo = FormatData.parseDateToTring(dateTo);
				query.append(" AND (iss.CreatedDate <= '" + shipDateTo + "' OR iss.CreatedDate IS NULL)");
			}
			
			log.debug("=========TAU SEARCH --countIssuePermissionForTransitInfo========" + query.toString());
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.LONG);
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if (Validator.isNotNull(maritimeCode) && maritimeCode.trim().length() > 0 && !maritimeCode.trim().equalsIgnoreCase("LUA_CHON")) {
				qPos.add(maritimeCode.trim());
			}
			if (Validator.isNotNull(portCode) && portCode.trim().length() > 0 && !portCode.trim().equalsIgnoreCase("LUA_CHON1")) {
				qPos.add(portCode.trim());
			}
			
			Iterator<Long> itr = q.list().iterator();
			
			if (itr.hasNext()) {
				Long count = itr.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countByDocumentNameAndDocumentYear(long documentName, int documentYear) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT count(*) as total FROM issue_permission_for_transit iss ");
			query.append("where DocumentName = ? and DocumentYear = ?");
			
			log.debug("=======countByDocumentNameAndDocumentYear====countByDocumentNameAndDocumentYear========" + query.toString());
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.LONG);
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(documentName);
			qPos.add(documentYear);
			
			Iterator<Long> itr = q.list().iterator();
			
			if (itr.hasNext()) {
				Long count = itr.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public IssuePermissionForTransit findIssuePermissionForTransitByDocumentYearAndDocumentYearAndRequestState(long documentName, int documentYear,
			int requestState) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			query.append("SELECT * FROM issue_permission_for_transit ");
			query.append(" WHERE DocumentName = ? and DocumentYear = ? and RequestState = ? ");
			
			log.debug("=========findIssuePermissionForTransitByDocumentYearAndDocumentYearAndRequestState========" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity("IssuePermissionForTransit", IssuePermissionForTransitImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(documentName);
			qPos.add(documentYear);
			qPos.add(requestState);
			
			// execute the query and return a list from the db
			return (IssuePermissionForTransit) q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		
		return null;
	}
	
	/**
	 * ascOrdesc: ASC is true, DESC is false
	 */
	public List<IssuePermissionForTransit> findByDocumentYearAndDocumentYearOrderByColumn(long documentName, int documentYear, String orderByColumn,
			boolean ascOrdesc) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT * FROM issue_permission_for_transit WHERE DocumentName = ? and DocumentYear = ? ORDER BY " + orderByColumn);
			
			if (ascOrdesc) {
				query.append(" asc");
			} else {
				query.append(" desc");
			}
			
			String sql = query.toString();
			log.debug("=========findByDocumentYearAndDocumentYearOrderByColumn========" + sql);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("IssuePermissionForTransit", IssuePermissionForTransitImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(documentName);
			qPos.add(documentYear);
			
			// execute the query and return a list from the db
			return (List<IssuePermissionForTransit>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return new ArrayList<IssuePermissionForTransit>();
	}
	
	public String capGiayPhepSo(String maritimeReference) throws SystemException {
		Session session = null;
		try {
			if (Validator.isNotNull(maritimeReference) && maritimeReference.length() > 0) {
				session = openSession();
				StringBuilder query = new StringBuilder();
				
				query.append("select SUBSTRING(CertificateNo, 1, (length(CertificateNo) - 4)) as giayPhepSo from issue_shifting_order where CertificateNo like '%/" + maritimeReference + "' ");
				query.append("UNION ");
				query.append("select SUBSTRING(CertificateNo, 1, (length(CertificateNo) - 4)) as giayPhepSo from issue_port_clearance where CertificateNo like '%/" + maritimeReference + "' ");
				query.append("UNION ");
				query.append("select SUBSTRING(CertificateNo, 1, (length(CertificateNo) - 4)) as giayPhepSo from issue_permission_for_transit where CertificateNo like '%/" + maritimeReference + "' ");
				
				log.debug("==capGiayPhepSo==" + query.toString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addScalar("giayPhepSo", Type.STRING);
				q.setCacheable(false);
				
				QueryPos qPos = QueryPos.getInstance(q);
				
				List<String> lstGiayPhepSo = (List<String>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				
				List<String> lstMax = new ArrayList<String>();
				for (String giayPhepSo : lstGiayPhepSo) {
					//log.info("==giayPhepSo==" + giayPhepSo);
					if (Validator.isNotNull(giayPhepSo)) {
						if (giayPhepSo.length() == 10) {
							lstMax.add(giayPhepSo);
						}
					}
				}
				
				String max = Collections.max(lstMax);
				
				log.info("==capGiayPhepSo==MAX==" + max);
				String sMax = "" + max;
				if(sMax.length() < 10) {
					return "0000000001";
				} else {
					Integer iGiayPhepSoMoi = (FormatData.convertToInt(sMax)) + 1;
					return ConvertUtil.capSoGiayPhep(iGiayPhepSoMoi + "");
				}
			}
			return "";
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
}
