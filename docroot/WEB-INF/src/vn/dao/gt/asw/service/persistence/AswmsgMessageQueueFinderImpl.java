package vn.dao.gt.asw.service.persistence;

import java.util.List;





import vn.dao.gt.asw.model.AswmsgMessageQueue;
import vn.dao.gt.asw.model.impl.AswmsgMessageQueueImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class AswmsgMessageQueueFinderImpl  extends BasePersistenceImpl<AswmsgMessageQueue> implements AswmsgMessageQueueFinder {
	private Log log = LogFactoryUtil.getLog(AswmsgMessageQueueFinderImpl.class);
	public List<AswmsgMessageQueue> getListMessage2Queue(int count){
		Session session = null;
		try {
			session = openSession();
			
			String sql = "SELECT * FROM aswmsg_messagequeue where priority > 0  order by priority desc, id asc " ;
			//String sql = "select id,CONVERT(allcontent USING utf8) allcontent from aswmsg_messagequeue order by priority desc " ;
			//String sql = "select id, CAST(allcontent AS CHAR(100000) CHARACTER SET utf8)  allcontent from aswmsg_messagequeue order by priority desc " ;
			
			sql=sql+ " limit "+count;
			
			System.out.println("=========findMotCuaPhieuXuLyChinhByHoSoThuTucId===" + sql);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("AswmsgMessageQueue", AswmsgMessageQueueImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			return (List<AswmsgMessageQueue>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public boolean updatePriorityAswmsgMessageQueue(long priority, long id) {
		Session session = null;
		//	List<VehicleRecord> result = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			query.append("UPDATE aswmsg_messagequeue SET priority =   "+priority);
			query.append("  where  id = " + id);
			
			//
			//String sql = "SELECT * FROM vr_vehiclerecord LEFT JOIN vr_vehiclegroup on vr_vehiclegroup.id = vr_vehiclerecord.vehiclegroupid LEFT JOIN vr_registeredinspection on vr_registeredinspection.id = vr_vehiclegroup.registeredinspectionid where vr_registeredinspection.dossierid = " + dossierId;
			
			log.debug("=========updatePriorityAswmsgMessageQueue===" + query.toString());
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.executeUpdate();
			//q.setCacheable(false);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		
		return false;
	}
}
