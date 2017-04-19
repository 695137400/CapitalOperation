(function () {
    var slideMenus = {
        home:function(){
            api.execScript({
                name: 'slide',
                script: 'menus.home()'
            });
            api.closeSlidPane();
        },
        star:function () {
            api.execScript({
                name: 'slide',
                script: 'menus.star()'
            });
            api.closeSlidPane();
        },
        calendar:function () {
            api.execScript({
                name: 'slide',
                script: 'menus.calendar()'
            });
            api.closeSlidPane();
        },
        date:function () {
            api.execScript({
                name: 'slide',
                script: 'menus.date()'
            });
            api.closeSlidPane();
        },
        flag:function () {
            api.execScript({
                name: 'slide',
                script: 'menus.flag()'
            });
            api.closeSlidPane();
        },
        question:function () {
            api.execScript({
                name: 'slide',
                script: 'menus.question()'
            });
            api.closeSlidPane();
        },
        cert:function () {
            api.execScript({
                name: 'slide',
                script: 'menus.cert()'
            });
            api.closeSlidPane();
        },
        back:function () {
            api.execScript({
                name: 'slide',
                script: 'menus.back()'
            });
            api.closeSlidPane();
        }
    };
    //主页
    $('#list-home').click(function () {
        slideMenus.home();
    });
    //收藏
    $('#list-star').click(function () {
        slideMenus.star();
    });
    //预约
    $('#list-calendar').click(function () {
        slideMenus.calendar();
    });
    //提醒
    $('#list-date').click(function () {
        slideMenus.date();
    });
    //历史
    $('#list-flag').click(function () {
        slideMenus.flag();
    });
    //帮助
    $('#list-question').click(function () {
        slideMenus.question();
    });
    $('#list-cert').click(function () {
        slideMenus.cert();
    });
    $('#list-back').click(function () {
        slideMenus.back();
    });
})();
