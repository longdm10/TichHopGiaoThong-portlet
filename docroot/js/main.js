function viewKetQuaHoSo(url, titleBieuMau) {
	var _title = null;
	if (titleBieuMau.length = 0) {
		_title = 'BIỂU MẪU HỒ SƠ';
	} else {
		_title = titleBieuMau;
	}
	
	AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
		
		var dialog = new A.Dialog({
			title : _title,
			draggable : true,
			modal : true,
			centered : true,
			width : $(window).width() * 0.9,
			height : $(window).height() * 0.9,
		
		}).plug(A.Plugin.IO, {
			uri : url
		}).render();
	});
}