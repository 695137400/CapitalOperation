
Date.prototype.Format = function (formatStr) {
    var str = formatStr;
    str = str.replace(/yyyy|YYYY/, this.getFullYear());
    str = str.replace(/MM/, (this.getMonth() + 1) > 9 ? (this.getMonth() + 1).toString() : '0' + (this.getMonth() + 1));
    str = str.replace(/dd|DD/, this.getDate() > 9 ? this.getDate().toString() : '0' + this.getDate());
    str = str.replace(/hh|HH/, this.getHours() > 9 ? this.getHours().toString() : '0' + this.getHours());
    str = str.replace(/mm/, (this.getMinutes() + 1) > 9 && (this.getMinutes() + 1) <= 59 ? (this.getMinutes() + 1).toString() : ((this.getMinutes() + 1) <= 59 ? ('0' + (this.getMinutes() + 1)) : (this.getMinutes())));
    str = str.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds().toString() : '0' + this.getSeconds());
    return str;
};
/**
 * 返回
 */
function sliding() {
    api.openSlidPane({
        type: 'left'
    });
}
/**
 * 新建
 */
function newMean() {
    api.openWin({
        name: 'new',
        bgColor: "#ffffff",
        url: 'new.html',
        pageParam: {
            name: 'test',
            type:'edit'
        }
    });
}
apiready = function () {
    /**
     * 安卓返回按钮监控
     */
    api.addEventListener({
        name: 'keyback'
    }, function (ret, err) {
        api.closeWidget();
    });
    window.toast = new auiToast({});
    window.api = api;
    window.ApiUtil = api.require('ApiUtil');
    ApiUtil.copyFileToData({
        oldDirName: "contact",
        newDirName: "contact"
    }, function (e) {
        ApiUtil.log({tag: 'copyFileToData', message: e});
    });

    /**
     * 三个主页展示列表
     */
    menus.init();
    $('#tab-home').click(function () {
        menus.home();
    })
    $('#tab-star').click(function () {
        menus.star();
    })
    $('#tab-my').click(function () {
        menus.my();
    })
};
var menus = {
    init: function () {
        api.openFrameGroup({
            name: 'menus',
            scrollEnabled: false,
            rect: {
                x: 'auto',
                y: '45',
                w: api.winWidth,
                h: (api.winHeight - $api.dom('#tab').offsetHeight) - 40
            },
            frames: [
                {
                    name: 'home',//0
                    url: 'zhu_ye.html',
                    pageParam:{
                        selectParam:$('#search-input').val()
                    }
                },
                {
                    name: 'star',//1
                    url: 'shou_cang.html',
                    pageParam:{
                        selectParam:$('#search-input').val()
                    }
                },
                {
                    name: 'my',//2
                    url: 'ge_ren_zhong_xin.html'
                },
                {
                    name: 'calendar',//3
                    url: 'yu_yue.html',
                    pageParam:{
                        selectParam:$('#search-input').val()
                    }
                },
                {
                    name: 'date',//4
                    url: 'ti_xing.html',
                    pageParam:{
                        selectParam:$('#search-input').val()
                    }
                },
                {
                    name: 'flag',//5
                    url: 'li_shi.html',
                    pageParam:{
                        selectParam:$('#search-input').val()
                    }
                },
                {
                    name: 'question',//6
                    url: 'bang_zhu.html'
                },
                {
                    name: 'cert',//7
                    url: 'cert.html'
                }
            ]
        });
    },
    close: function () {
        api.closeFrameGroup({
            name: 'menus'
        });
        this.init();
    },
    home: function () {
        this.close();
        var tab_home = $('#tab-home');
        $('#tab').children().removeClass('aui-active');
        $(tab_home).addClass('aui-active');
        api.setFrameGroupIndex({
            name: 'menus',
            index: 0
        });
    },
    search: function (index) {
        console.log('index：'+index);
        if (index == '0'){
            this.close();
        }
        if (index == 1){
            this.star();
            api.setFrameGroupIndex({
                name: 'menus',
                index: 1
            });
        }
        if (index == '2'){
            //this.close();
        }
        if (index == 3){
            this.calendar();
            api.setFrameGroupIndex({
                name: 'menus',
                index: 3
            });
        }
        if (index == 4){
            this.date();
            api.setFrameGroupIndex({
                name: 'menus',
                index: 4
            });
        }
        if (index == 5){
            this.flag();
            api.setFrameGroupIndex({
                name: 'menus',
                index: 5
            });
        }
    },
    clear: function () {
        $('#search-input').val('');
    },
    star: function () {
        $('#search-input').attr('data-index',1);
        this.close();
        var tab_home = $('#tab-star');
        $('#tab').children().removeClass('aui-active');
        $(tab_home).addClass('aui-active');
        api.setFrameGroupIndex({
            name: 'menus',
            index: 1
        });
    },
    my: function () {
        $('#search-input').attr('data-index',2);
        this.close();
        var tab_home = $('#tab-my');
        $('#tab').children().removeClass('aui-active');
        $(tab_home).addClass('aui-active');
        api.setFrameGroupIndex({
            name: 'menus',
            index: 2
        });
    },
    calendar: function () {
        $('#search-input').attr('data-index',3);
        this.close();
        $('#tab').children().removeClass('aui-active');
        api.setFrameGroupIndex({
            name: 'menus',
            index: 3
        });
    },
    date: function () {
        $('#search-input').attr('data-index',4);
        this.close();
        $('#tab').children().removeClass('aui-active');
        api.setFrameGroupIndex({
            name: 'menus',
            index: 4
        });
    },
    flag: function () {
        $('#search-input').attr('data-index',5);
        this.close();
        $('#tab').children().removeClass('aui-active');
        api.setFrameGroupIndex({
            name: 'menus',
            index: 5
        });
    },
    question: function () {
        $('#search-input').attr('data-index',6);
        this.close();
        $('#tab').children().removeClass('aui-active');
        api.setFrameGroupIndex({
            name: 'menus',
            index: 6
        });
    },
    cert: function () {
        $('#search-input').attr('data-index',7);
        this.close();
        $('#tab').children().removeClass('aui-active');
        api.setFrameGroupIndex({
            name: 'menus',
            index: 7
        });
    },
    back: function () {
        ApiUtil.Toast({
            type: "loading",
            isHide: "false"
        });
        ApiUtil.copyDataToFile({
            oldDirName: "contact",
            newDirName: new Date().Format('YYYYMMDDHHmmss')
        }, function (e) {
            if (e.results) {
                setTimeout(function () {
                    ApiUtil.Toast({
                        type: "success",
                        isHide: "false"
                    });
                    setTimeout(function () {
                        ApiUtil.Toast({
                            type: "success",
                            isHide: "true"
                        });
                        alert("数据已经备份至内存卡，[数据]文件夹，\n以时间命名的一个db文件，可以用专用数据库管理软件打开,请注意保存！");
                    }, 500);
                }, 2000);
            } else {
                setTimeout(function () {
                    ApiUtil.Toast({
                        type: "fail",
                        isHide: "false"
                    });
                    setTimeout(function () {
                        ApiUtil.Toast({
                            type: "fail",
                            isHide: "true"
                        });
                    }, 500);
                }, 2000);
            }
            ApiUtil.log({tag: 'copyDataToFile', message: e});
        });
    }
};

