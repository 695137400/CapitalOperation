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
            name: 'test'
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
        alert(ret);
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
                    url: 'zhu_ye.html'
                },
                {
                    name: 'star',//1
                    url: 'shou_cang.html'
                },
                {
                    name: 'my',//2
                    url: 'ge_ren_zhong_xin.html'
                },
                {
                    name: 'calendar',//3
                    url: 'yu_yue.html'
                },
                {
                    name: 'date',//4
                    url: 'ti_xing.html'
                },
                {
                    name: 'flag',//5
                    url: 'li_shi.html'
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
    star: function () {
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
        this.close();
        $('#tab').children().removeClass('aui-active');
        api.setFrameGroupIndex({
            name: 'menus',
            index: 3
        });
    },
    date: function () {
        this.close();
        $('#tab').children().removeClass('aui-active');
        api.setFrameGroupIndex({
            name: 'menus',
            index: 4
        });
    },
    flag: function () {
        this.close();
        $('#tab').children().removeClass('aui-active');
        api.setFrameGroupIndex({
            name: 'menus',
            index: 5
        });
    },
    question: function () {
        this.close();
        $('#tab').children().removeClass('aui-active');
        api.setFrameGroupIndex({
            name: 'menus',
            index: 6
        });
    },
    cert: function () {
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
            newDirName: "contact"
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

