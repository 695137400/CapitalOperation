var dbname = "/sdcard/APICloud/APICloud.db";
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
		//TODO
		//这里是滑动菜单触发事件
	});

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

/*
fs.remove({
    path: 'fs:\/sdcard/APICloud/APICloud.db'
}, function(ret, err){        
    if( ret.status ){
        alert( "删除成功->"+JSON.stringify( ret ) );
    }else{
        alert("删除失败->"+ JSON.stringify( err ) );
    }
});
	var db = api.require('db');
	db.openDatabase({
		name : dbname
	}, function(ret, err) {
		if (ret.status) {
			api.toast({
				msg : '正在拷贝数据库......',
			});
			*//**
			 *创建菜单表
			 *
			 db.executeSql({
			 name : dbname,
			 sql : ('CREATE TABLE if not exists "APICloudMenu" (' + '"menuId" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,' + '"menuName" TEXT (200) NOT NULL,' + '"menuUrl" TEXT (500),' + '"menuPic" TEXT (1000),' + '"menuSequence" INTEGER,' + '"menuGradeId" INTEGER,' + '"menuParent" INTEGER,' + '"menuDirection" INTEGER);')
			 }, function(ret, err) {
			 if (ret.status) {
			 api.toast({
			 msg:"创建菜单表成功!",
			 duration:60
			 });
			 } else {
			 api.toast({
			 msg:"创建菜单表出错!->："+JSON.stringify(err),
			 duration:60
			 });
			 }
			 });

			 **
			 *创建正文信息表
			 *
			 db.executeSql({
			 name : dbname,
			 sql : ('CREATE TABLE if not exists "APICloudDetail" (' + '"detailId"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,' + '"menuId"  INTEGER NOT NULL,' + '"detailTitle"  TEXT,' + '"detailText"  TEXT);')
			 }, function(ret, err) {
			 if (ret.status) {
			 api.toast({
			 msg:"创建正文信息表成功，现在开始使用吧！" ,
			 duration:600000
			 });
			 } else {
			 api.toast({
			 msg:"创建正文信息表出错!->：" + JSON.stringify(err),
			 duration:60
			 });
			 }
			 });*//*
		} else {
			//TODO
			//
		}
	});*/

}

