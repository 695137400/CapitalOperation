function sliding() {
	api.openSlidPane({
		type : 'left'
	});
}
var api = {};
apiready = function() {
	api = api;
	$api.fixStatusBar($api.dom('.header'));
	api.addEventListener({
		name : 'keyback'
	}, function(ret, err) {
		api.closeWidget();
	});
	
}; 

function ok(){
	alert(JSON.stringify(api));
	var fs = api.require('fs');
	fs.copyTo({
		oldPath : 'fs:\/sdcard/软件/nanjing.jpg',
		newPath : 'fs:\/sdcard/APICloud.jpg'
	}, function(ret, err) {
		if (ret.status) {
			alert('OK'+JSON.stringify(ret));
		} else {
			alert('NO'+JSON.stringify(err));
		}
	});
}