//全局回调
function callback(msg,callNme) {
    if(callNme=="baseEnumQueryCallBack"){
        baseEnumQueryCallBack(msg);
    }else if(callNme=="addEnumDictsCallBack"){
        addEnumDictsCallBack(msg);
    }
}
//枚举查询回调
function baseEnumQueryCallBack(msg){
    innerHtmlForTemplate('enumTbody','enum_Template',msg);
}

//加载基础枚举
function thisOnLoad(){
    var data={
    };
    ajaxPost("enumDeclareControl/baseEnumQuery.req",data,"baseEnumQueryCallBack");
}

//新增枚举回掉
function addEnumDictsCallBack(msg){
    var index=parent.layer.getFrameIndex(window.name);
    parent.location.reload();
    parent.layer.close(index);
}
//新增枚举
function addEnumDicts(){
    var e_numcols=$("#enumcols").val();

    if(e_numcols.substr(0, 2)!="E_"){
        layer.msg('枚举必须以 E_ 开头', {
            icon: 2,
            time: 1000
        });
        return;
    }
    var data={
        enumcols:e_numcols,
        enumname:$("#enumname").val()
    };
    ajaxPost("enumDeclareControl/addEnumDicts.req",data,"addEnumDictsCallBack");
}