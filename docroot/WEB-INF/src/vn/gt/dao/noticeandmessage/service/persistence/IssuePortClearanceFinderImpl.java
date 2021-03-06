package vn.gt.dao.noticeandmessage.service.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import vn.gt.dao.noticeandmessage.model.IssuePortClearance;
import vn.gt.dao.noticeandmessage.model.impl.IssuePortClearanceImpl;
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

public class IssuePortClearanceFinderImpl extends BasePersistenceImpl<IssuePortClearance> implements IssuePortClearanceFinder {
	
	private Log log = LogFactoryUtil.getLog(IssuePortClearanceFinderImpl.class);
	
	public IssuePortClearance findLastestIssuePortClearanceByPortNameAndCallSign(String nameOfShip, String callSign) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			query.append("SELECT * FROM issue_port_clearance where 1 = 1 ");
			
			//query by nameofship
			if(Validator.isNotNull(nameOfShip) && nameOfShip.trim().length() > 0) {
				query.append(" AND NameOfShip like '%" + nameOfShip.trim() + "%' ");
			}
			//query by callSign
			if(Validator.isNotNull(callSign) && callSign.trim().length() > 0) {
				query.append(" AND CallSign like '%" + callSign.trim() + "%' ");
			}
			
			query.append("ORDER BY ApprovalDate DESC limit 1 ");
			
			String sql = query.toString();
			log.info("=========findByRequestCode========" + sql);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("IssuePortClearance", IssuePortClearanceImpl.class);
			return (IssuePortClearance) q.uniqueResult();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public List<IssuePortClearance> findIssuePortClearanceInfo(String requestState, String maritimeCode, String portCode, String shipName,
			String callSign, String shipDateFrom, String shipDateTo, int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT iss.* FROM issue_port_clearance iss ");
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
				query.append(" AND (iss.IssueDate >= '" + shipDateFrom + "' OR iss.IssueDate IS NULL)");
			}
			
			// Den ngay
			if (Validator.isNotNull(shipDateTo) && shipDateTo.trim().length() > 0) {
				Date dateTo = FormatData.parseDateShort3StringToDate(shipDateTo.trim());
				shipDateTo = FormatData.parseDateToTring(dateTo);
				query.append(" AND (iss.IssueDate <= '" + shipDateTo + "' OR iss.IssueDate IS NULL)");
			}
			// query.append(" ORDER BY id DESC");
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity("IssuePortClearance", IssuePortClearanceImpl.class);
			log.debug("=========TAU SEARCH --findIssuePortClearanceInfo========" + query.toString());
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(maritimeCode) && maritimeCode.trim().length() > 0 && !maritimeCode.trim().equalsIgnoreCase("LUA_CHON")) {
				qPos.add(maritimeCode);
				log.debug("===qPos.add===maritimeCode===" + maritimeCode);
			}
			if (Validator.isNotNull(portCode) && portCode.trim().length() > 0 && !portCode.trim().equalsIgnoreCase("LUA_CHON1")) {
				qPos.add(portCode);
				log.debug("===qPos.add===portCode===" + maritimeCode);
			}
			return (List<IssuePortClearance>) QueryUtil.list(q, getDialect(), start, end);
			
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countIssuePortClearanceInfo(String requestState, String maritimeCode, String portCode, String shipName, String callSign,
			String shipDateFrom, String shipDateTo) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT count(*) as total FROM issue_port_clearance iss ");
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
				query.append(" AND (iss.IssueDate >= '" + shipDateFrom + "' OR iss.IssueDate IS NULL)");
			}
			
			// Den ngay
			if (Validator.isNotNull(shipDateTo) && shipDateTo.trim().length() > 0) {
				Date dateTo = FormatData.parseDateShort3StringToDate(shipDateTo.trim());
				shipDateTo = FormatData.parseDateToTring(dateTo);
				query.append(" AND (iss.IssueDate <= '" + shipDateTo + "' OR iss.IssueDate IS NULL)");
			}
			
			log.debug("=========TAU SEARCH --countIssuePortClearanceInfo========" + query.toString());
			
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
	
	public List<IssuePortClearance> findIssuePortClearanceByDocumentYearAndDocumentYear(long documentName, int documentYear) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT * FROM ISSUE_PORT_CLEARANCE WHERE DocumentName = ? and DocumentYear = ? ");
			
			String sql = query.toString();
			log.debug("=========findIssuePortClearanceByDocumentYearAndDocumentYear========" + sql);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("IssuePortClearance", IssuePortClearanceImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(documentName);
			qPos.add(documentYear);
			
			// execute the query and return a list from the db
			return (List<IssuePortClearance>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return new ArrayList<IssuePortClearance>();
	}
	
	public int countByDocumentYearAndDocumentYear(long documentName, int documentYear) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			query.append("SELECT count(*) as total FROM ISSUE_PORT_CLEARANCE WHERE DocumentName = ? and DocumentYear = ? ");
			
			log.debug("=========countByDocumentYearAndDocumentYear========" + query.toString());
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return 0;
	}
	
	public List<IssuePortClearance> findIssuePortClearanceByDocumentYearAndDocumentYearAndRequestState(long documentName, int documentYear,
			int requestState) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT * FROM ISSUE_PORT_CLEARANCE WHERE DocumentName = ? and DocumentYear = ? and RequestState = ? ");
			
			String sql = query.toString();
			log.debug("=========findIssuePortClearanceByDocumentYearAndDocumentYearAndRequestState========" + sql);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("IssuePortClearance", IssuePortClearanceImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(documentName);
			qPos.add(documentYear);
			qPos.add(requestState);
			
			// execute the query and return a list from the db
			return (List<IssuePortClearance>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return new ArrayList<IssuePortClearance>();
	}
	
	public IssuePortClearance findByRequestCode(String requestCode) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT * FROM ISSUE_PORT_CLEARANCE WHERE RequestCode = ? ");
			
			String sql = query.toString();
			log.debug("=========findByRequestCode========" + sql);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("IssuePortClearance", IssuePortClearanceImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(requestCode);
			
			// execute the query and return a list from the db
			return (IssuePortClearance) q.uniqueResult();
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
	public List<IssuePortClearance> findByDocumentYearAndDocumentYearOrderByColumn(long documentName, int documentYear, String orderByColumn,
			boolean ascOrdesc) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT * FROM issue_port_clearance WHERE DocumentName = ? and DocumentYear = ? ORDER BY " + orderByColumn + " ");
			
			if (ascOrdesc) {
				query.append("asc");
			} else {
				query.append("desc");
			}
			
			String sql = query.toString();
			log.debug("=========findByDocumentYearAndDocumentYearOrderByColumn========" + sql);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("IssuePortClearance", IssuePortClearanceImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(documentName);
			qPos.add(documentYear);
			
			// execute the query and return a list from the db
			return (List<IssuePortClearance>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return new ArrayList<IssuePortClearance>();
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
