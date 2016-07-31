function sliding() {
	api.openSlidPane({
		type : 'left'
	});
}

apiready = function() {
	$api.fixStatusBar($api.dom('.header'));
	api.addEventListener({
		name : 'keyback'
	}, function(ret, err) {
		api.closeWidget();
	});
}; 