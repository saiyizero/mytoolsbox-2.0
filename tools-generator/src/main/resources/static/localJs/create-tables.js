//全局回调
function callback(msg,callNme) {
    if(callNme=="queryTablesCallBack"){
        queryTablesCallBack(msg);
    }
}


//打开表结构
function openTables(frameNme,tablesNme){
    var shownme=frameNme+': '+tablesNme;
    layer_show(shownme,'create-tables-show.html','850','630');
}

//登陆时载入表结构回掉
function queryTablesCallBack(msg){
    innerHtmlForTemplate('myTbody','table_Template',msg);
}

//登陆时载入表结构
function queryTables(){

    var data={
    };
    ajaxPost("createTablesControl/queryTables.req",data,"queryTablesCallBack");
}