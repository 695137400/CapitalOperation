apiready = function() {
	api.openSlidLayout({
		type : 'all',
		leftEdge : 60,
		fixedPane : {
			name : 'fixed',
			url : 'html/fixed.html'
		},
		slidPane : {
			name : 'slide',
			url : 'html/slide.html'
		}
	}, function(ret) {

	});
		var db = api.require('db');
		db.openDatabase({
			name : "/sdcard/APICloud/APICloud.db"
		}, function(ret, err) {
			if (ret.status) {
				console.log(JSON.stringify(ret));
			} else {
				console.log(JSON.stringify(err));
			}
		});
}

