//全局回调
function callback(msg,callNme) {
    if(callNme=="addNmeListCallBack"){
        addNmeListCallBack(msg);
    }else if(callNme=="findNmeListCallBack"){
        findNmeListCallBack(msg);
    }else if(callNme=="getLocalPathCallBack"){
        getLocalPathCallBack(msg);
    }else if(callNme=="ScanNmeListForSuffixCallBack"){
        ScanNmeListForSuffixCallBack(msg);
    }else if(callNme=="ScanNmeListForFileNmeCallBack"){
        ScanNmeListForFileNmeCallBack(msg);
    }else if(callNme=="findBlackListCallBack"){
        findBlackListCallBack(msg);
    }else if(callNme=="getLocalPathByNameCallBack"){
        getLocalPathByNameCallBack(msg);
    }else if(callNme=="batchMoveFileCallBack"){
        batchMoveFileCallBack(msg);
    }else if(callNme=="batchDeleteFileCallBack"){
        batchDeleteFileCallBack(msg);
    }else if(callNme=="delSuffixCallBack"){
        delSuffixCallBack(msg);
    }
}

//删除后缀
function deleteSuffix(gropName,suffName,gropType){
    layer.confirm('确认要删除: '+suffName+'？',function(index){
        var data= {
            gropName:gropName,
            suffName:suffName,
            gropType:gropType
        }
        ajaxPost("fileBatchController.delSuffix.action",data,"delSuffixCallBack");
    });
}
function delSuffixCallBack(msg){
    location.replace(location.href);
}

function barchRemove(){
    var data= {
        staPath:$("#filpath").val(),
        scanTyp:"delete"
    }
    ajaxPost("fileBatchController.batchDeleteFile.action",data,"batchDeleteFileCallBack");
}
function batchDeleteFileCallBack(msg){
    appendFortextArea("delTextarea",msg);
}
//根据扫描列表批量移动文件
function batchMove(){
    var data= {
        staPath:$("#staPath").val(),
        endPath:$("#endPath").val(),
        scanTyp:"move"
    }
    ajaxPost("fileBatchController.batchMoveFile.action",data,"batchMoveFileCallBack");
}
function batchMoveFileCallBack(msg){
    appendFortextArea("moveTextarea",msg);
}
function appendFortextArea(htmlid,msg){
    var textArea=document.getElementById(htmlid);

    for(k in msg.myList){
        var child=document.createTextNode(msg.myList[k].filePath+"\r\n");
        textArea.appendChild(child);
        textArea.scrollTop = textArea.scrollHeight;
    }
}


//批量维护黑名单
function batchAddBlackList(){
    obj = document.getElementsByName("myChecbox");
    check_val = [];
    for(k in obj){
        if(obj[k].checked){
            var data= {
                gropName:"黑名单",
                suffName:obj[k].value,
                gropType:"filnme"
            }
            ajaxAsync("fileBatchController.addNmeList.action",data);
        }
    }
    var index=parent.layer.getFrameIndex(window.name);
    parent.location.reload();
    parent.layer.close(index);
}

//批量维护后缀
function batchAddSuffix(){
    obj = document.getElementsByName("myChecbox");
    check_val = [];
    for(k in obj){
        if(obj[k].checked){
            var data= {
                gropName:$("#grop_name").val(),
                suffName:obj[k].value,
                gropType:"suffix"
            }
            ajaxAsync("fileBatchController.addNmeList.action",data);
        }
    }
    var index=parent.layer.getFrameIndex(window.name);
    parent.location.reload();
    parent.layer.close(index);
}

//扫描指定目录获取后缀
function scanFilename(){
    $("#myTbody").html('');
    var data= {
        filpath:$("#filpath").val()
    }
    ajaxPost("fileBatchController.ScanNmeListForFileNme.action",data,"ScanNmeListForFileNmeCallBack");
}
function ScanNmeListForFileNmeCallBack(msg) {
    innerHtmlForTemplate('myTbody','scanList_Template',msg);
    table_refurbish();
}

//扫描指定目录获取后缀
function scanSuffix(){
    $("#myTbody").html('');
    var data= {
        filpath:$("#filpath").val(),
        gropName:$("#grop_name").val()
    }
    ajaxPost("fileBatchController.ScanNmeListForSuffix.action",data,"ScanNmeListForSuffixCallBack");
}
function ScanNmeListForSuffixCallBack(msg) {
    innerHtmlForTemplate('myTbody','scanList_Template',msg);
    table_refurbish();
}

//获取路径
function  getLocalPath(pageId) {
    var data= {
        pageId:pageId
    }
    ajaxPost("publicContriller.getLocalPathForFolder.action",data,"getLocalPathCallBack");
}
function  getLocalPathCallBack(msg) {
    $("#filpath").val(msg.filePath);
}

//获取路径根据名称
function  getLocalPathByName(pageId) {
    var data= {
        pageId:pageId
    }
    ajaxPost("publicContriller.getLocalPathForFolder.action",data,"getLocalPathByNameCallBack");
}
function  getLocalPathByNameCallBack(msg) {
    if(msg.name=='scan-batch-folder'){
        $("#filpath").val(msg.filePath);
        $("#staPath").val(msg.filePath);
    }
    if(msg.name=='move-batch-folder'){
        var date = new Date();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + month + strDate;
        var paths= msg.filePath;
        if(paths.search(currentdate)==-1){
            paths=paths+"\\"+currentdate;
        }
        $("#endPath").val(paths);
    }
}

//扫描名单列表置空
function scanNmelistLoad(){

}

//载入名单列表
function loadNmeList(){
    var data= {
        gropType:"filnme"
    }
    ajaxPost("fileBatchController.findNmeList.action",data,"findBlackListCallBack");
}
function findNmeListCallBack(msg){
    innerHtmlForTemplate('myTbody','nmeList_Template',msg);
    table_refurbish();
}
function findBlackListCallBack(msg){
    innerHtmlForTemplate('myBlackTableTbody','blackList_Template',msg);
    var data= {
        gropType:"suffix"
    }
    ajaxPost("fileBatchController.findNmeList.action",data,"findNmeListCallBack");
}


//新增后缀
function addNmeList(gropType){
    var grop_name=$("#grop_name").val();
    var suff_name=$("#suff_name").val();
    var data= {
        gropName:grop_name,
        suffName:suff_name,
        gropType:gropType
    }
    ajaxPost("fileBatchController.addNmeList.action",data,"addNmeListCallBack");
}
function addNmeListCallBack(msg) {
    var index=parent.layer.getFrameIndex(window.name);
    parent.location.reload();
    parent.layer.close(index);
}

String.prototype.endWith=function(endStr){
    var d=this.length-endStr.length;
    return (d>=0&&this.lastIndexOf(endStr)==d)
}