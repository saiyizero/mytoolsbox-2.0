//全局回调
function callback(msg,callNme) {
   if(callNme=="fuzzyQueryCallBack"){
      fuzzyQueryCallBack(msg);
   }else if(callNme=="createProjectCallBack"){
      createProjectCallBack(msg);
   }
}
//全量查询回调
function fuzzyQueryCallBack(msg){
   innerHtmlForTemplate('myTbody','detail_Template',msg);
   suffixPages(msg,'totalsize','paginateList');
}

//全量查询
function onchangePages(curpagno){
   var colsname=$("#colsname").val();
   var colsccmt=$("#colsccmt").val();

   var data={
      colsname:colsname,
      colsccmt:colsccmt,
      curpagno:curpagno,
      pagesize:"10"
   };
   ajaxPost("baseDeclareControl/fuzzyQuery.req",data,"fuzzyQueryCallBack");
}

function onSelectChange(){
   var colstype= $("#colstype").val();
   if(colstype=="EnumType"){
      layer_show('枚举字典','enum-declare.html','900','660');
   }
}

//键盘按下Tab事件
function myKeyDown(id){
   var keyname= event.keyCode;
   // if(keyname==9){
   //     alert(keyname);
   // }
}