//全局回调
function callback(msg,callNme) {
    if(callNme=="baseEnumQueryCallBack"){
        baseEnumQueryCallBack(msg);
    }else if(callNme=="addEnumDictsCallBack"){
        addEnumDictsCallBack(msg);
    }else if(callNme=="enumDetailQueryCallBack"){
        enumDetailQueryCallBack(msg);
    }else if(callNme=="addEnumDetailsCallBack"){
        addEnumDetailsCallBack(msg);
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

//当输入时模糊查询
function queryByEnumcols(){

    if (191 == event.keyCode && event.altKey) {
        var enumcols=$("#enumcols").val();
        var colsccmt=$("#colsccmt").val();

        var data={
            enumcols:enumcols
        };
        ajaxPost("enumDeclareControl/baseEnumQuery.req",data,"baseEnumQueryCallBack");
    }
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
        enumname:$("#enumname").val(),
        enumlegh:$("#enumlegh").val()
    };
    ajaxPost("enumDeclareControl/addEnumDicts.req",data,"addEnumDictsCallBack");
}

//枚举名细查询回调
function enumDetailQueryCallBack(msg){
    $("#dict_enumname").html(msg.enumcols+"&nbsp;&nbsp;&nbsp;["+msg.enumname+"]");

    $("#dict_enumcols").val(msg.enumcols);

    $("#enumlegh").val(msg.enumlegh);
    innerHtmlForTemplate('tableBody','enum_Detail_Template',msg);
}

//枚举名细查询
function enumDetailQuery(enumcol){
    var data={
        enumcols:enumcol
    };
    ajaxPost("enumDeclareControl/enumDetailQuery.req",data,"enumDetailQueryCallBack");
}

//新增枚举明细回调
function addEnumDetailsCallBack(msg){
    enumDetailQuery(msg.enumcols);
}

//新增枚举明细
function addEnumDetails(){

    var enumcolss=$("#dict_enumcols").val();
    var enumstats=$("#enumstat").val();
    var valudescs=$("#valudesc").val();
    var enumvalus=$("#enumvalu").val();
    var data={
        enumcols:enumcolss,
        enumstat:enumstats,
        valudesc:valudescs,
        enumvalu:enumvalus
    };
    ajaxPost("enumDeclareControl/addEnumDetails.req",data,"addEnumDetailsCallBack");
}

//选中该枚举
function selectPoint(enumcols){
    var point="<a href=\"javascript:void(0);\" onclick=\"changePoint();\">" +
        "<input  id='colstype' name='colstype' type='hidden' value='" + enumcols+"' /><span>" +enumcols +"</span></a>";

    var index=parent.layer.getFrameIndex(window.name);

    console.log(point);
    parent.$("#point_colstype").html(point);
    parent.layer.close(index);
}

