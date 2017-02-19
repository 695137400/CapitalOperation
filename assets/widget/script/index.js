apiready = function() {
	api.addEventListener({
		name: 'keyback'
	}, function (ret, err) {
		return false;
	});
    api.openSlidLayout({
		type : 'left',
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
		//TODO
		//这里是滑动菜单触发事件
	});
};
