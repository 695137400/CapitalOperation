apiready = function () {
    api.addEventListener({
        name: 'keyback'
    }, function (ret, err) {
        return false;
    });
    api.setStatusBarStyle({
        style: 'dark',
        color: '#000'
    });
};
var tab = new auiTab({
    element: document.getElementById("tab")
}, function (ret) {
    console.log(ret);
    var index = ret.index;
    api.execScript({
        name: 'slide',
        script: 'setMenu(' + (index-1) + ')'
    });
    api.closeSlidPane();
});
