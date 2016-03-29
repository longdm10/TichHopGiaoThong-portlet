<%@page import="vn.gt.dao.common.service.UserPortLocalServiceUtil"%>
<%@page import="vn.gt.dao.common.model.UserPort"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="vn.gt.dao.danhmucgt.service.DmGTBusinessTypeLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmucgt.model.DmGTBusinessType"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="vn.gt.dao.result.service.ResultNotificationLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="vn.gt.dao.result.model.ResultNotification"%>
<%@page import="vn.gt.utils.FormatData"%>
<%@page pageEncoding="UTF-8"%>
<style>
a.selected {
  background-color:#1F75CC;
  color:white;
  z-index:100;
}

.messagepop {
  background-color:#FFFFFF;
  border:1px solid #999999;
  cursor:default;
  display:none;
  margin-top: 15px;
  position:absolute;
  text-align:left;
  width:394px;
  height: 400px;
  z-index:50;
  padding: 25px 25px 20px;
  overflow: scroll;
}

label {
  display: block;
  margin-bottom: 3px;
  padding-left: 15px;
  text-indent: -15px;
}

.messagepop p, .messagepop.div {
  border-bottom: 1px solid #EFEFEF;
  margin: 8px 0;
  padding-bottom: 8px;
}
</style>
<%
String maritimeCode = null;
if(portDefault != null) {
	maritimeCode = portDefault.getPortCode();
}
List<ResultNotification> lstNotifications = null;

lstNotifications = ResultNotificationLocalServiceUtil.findByMaritimeCodeOrderbyLastestDate(maritimeCode);
%>
<div class="messagepop pop">
	<% 
	if (lstNotifications != null) {
	for(ResultNotification notification : lstNotifications) {
		DmGTBusinessType businessType = DmGTBusinessTypeLocalServiceUtil.getByBusinessTypeCode(notification.getBusinessTypeCode());
		if(notification.getRemarks().trim().length() > 0 && notification.getRemarks().trim().equals("NIL")) {
		%>
		<p><label><%=notification.getDocumentName()%>---[<%=FormatData.parseDateToTringType3(FormatData.parseStringToDate(notification.getLatestDate()))%>] Mới : <%=(businessType != null) ? businessType.getBusinessTypeName() : notification.getBusinessTypeCode()%></label></p>
		<%
		} else if(notification.getRemarks().trim().length() > 0) {
		%>
		<p><label><%=notification.getDocumentName()%>---[<%=FormatData.parseDateToTringType3(FormatData.parseStringToDate(notification.getLatestDate()))%>] <%=notification.getRemarks() %>---<%=(businessType != null) ? businessType.getBusinessTypeName() : notification.getBusinessTypeCode()%></label></p>
		<%	
		}
	}
	}
	%>
	<p><a class="close" href="/"><font color="red">Quay lại</font></a></p>
</div>
<a href="/contact" id="contact"><h2 class="tlemenu tlemain"><font color="blue">TIN MỚI</font></h2></a>

<script type="text/javascript">
function deselect(e) {
	  $('.pop').slideFadeToggle(function() {
	    e.removeClass('selected');
	  });    
	}

	$(function() {
	  $('#contact').on('click', function() {
	    if($(this).hasClass('selected')) {
	      deselect($(this));               
	    } else {
	      $(this).addClass('selected');
	      $('.pop').slideFadeToggle();
	    }
	    return false;
	  });

	  $('.close').on('click', function() {
	    deselect($('#contact'));
	    return false;
	  });
	});

	$.fn.slideFadeToggle = function(easing, callback) {
	  return this.animate({ opacity: 'toggle', height: 'toggle' }, 'fast', easing, callback);
	};
</script>
