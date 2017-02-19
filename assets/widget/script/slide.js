function sliding() {
    api.openSlidPane({
        type: 'left'
    });
}
function newMean() {
    api.openWin({
        name: 'new',
        bgColor:"#ffffff",
        url: 'new.html',
        pageParam: {
            name: 'test'
        }
    });
}
var api = {};
apiready = function () {
    api = api;
    api.addEventListener({
        name: 'keyback'
    }, function (ret, err) {
        return false;
    });
    api.openFrameGroup({
        name: 'home',
        scrollEnabled: false,
        rect: {
            x: 'auto',
            y: '45',
            w: 'auto',
            h: screen.height - 100
        },
        frames: [
            {
                name: 'zhu_ye',
                url: 'zhu_ye.html'
            }, {
                name: 'shou_cang',
                url: 'shou_cang.html'
            }, {
                name: 'ge_ren_zhong_xin',
                url: 'ge_ren_zhong_xin.html'
            }
        ]
    }, function (ret, err) {
        console.log(JSON.stringify(ret));
        console.log(JSON.stringify(err));
    });
};
function setHome(index) {
    api.closeFrameGroup({
        name:"menu"
    });
    api.openFrameGroup({
        name: 'home',
        scrollEnabled: false,
        rect: {
            x: 'auto',
            y: '45',
            w: 'auto',
            h: screen.height - 100
        },
        frames: [
            {
                name: 'zhu_ye',
                url: 'zhu_ye.html'
            }, {
                name: 'shou_cang',
                url: 'shou_cang.html'
            }, {
                name: 'ge_ren_zhong_xin',
                url: 'ge_ren_zhong_xin.html'
            }
        ]
    }, function (ret, err) {
        console.log(JSON.stringify(ret));
        console.log(JSON.stringify(err));
    });
    api.setFrameGroupIndex({
        name: 'home',
        index: index
    }, function (ret, err) {
        console.log(JSON.stringify(ret));
        console.log(JSON.stringify(err));
    });
}
function setMenu(index) {
    api.closeFrameGroup({
        name:"home"
    });
    api.openFrameGroup({
        name: 'menu',
        scrollEnabled: false,
        rect: {
            x: 'auto',
            y: '45',
            w: 'auto',
            h: screen.height - 100
        },
        frames: [
            {
                name: 'zhu_ye',
                url: 'zhu_ye.html'
            }, {
                name: 'shou_cang',
                url: 'shou_cang.html'
            }, {
                name: 'an_pai',
                url: 'an_pai.html'
            }, {
                name: 'ti_xing',
                url: 'ti_xing.html'
            }, {
                name: 'li_shi',
                url: 'li_shi.html'
            }, {
                name: 'bang_zhu',
                url: 'bang_zhu.html'
            }
        ]
    }, function (ret, err) {
        console.log(JSON.stringify(ret));
        console.log(JSON.stringify(err));
    });
    api.setFrameGroupIndex({
        name: 'menu',
        index: index
    }, function (ret, err) {
        console.log(JSON.stringify(ret));
        console.log(JSON.stringify(err));
    });
}
var tab = new auiTab({
    element: document.getElementById("tab")
}, function (ret) {
    var index = ret.index;
    setHome(index - 1);
});
