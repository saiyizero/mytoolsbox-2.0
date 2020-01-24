//全局回调
function callback(msg,callNme) {
   if(callNme=="fuzzyQueryCallBack"){
      fuzzyQueryCallBack(msg);
   }else if(callNme=="blurredQueryCallBack"){
      blurredQueryCallBack(msg);
   }else if (callNme=="addWordBookCallBack"){
      addWordBookCallBack(msg);
   }
}
//全量查询回调
function fuzzyQueryCallBack(msg){
   innerHtmlForTemplate('myTbody','detail_Template',msg);
   suffixPages(msg,'totalsize','paginateList');

}

//全量查询
function onchangePages(curpagno){
   if(curpagno==null){
      return;
   }

   var colsname=$("#colsname").val();
   var colsccmt=$("#colsccmt").val();

   var data={
      colsname:colsname,
      colsccmt:colsccmt,
      curpagno:curpagno,
      pagesize:"8"
   };
   ajaxPost("baseDeclareControl/blurredQuery.req",data,"blurredQueryCallBack");
}

function blurredQueryCallBack(msg){
   innerHtmlForTemplate('myTbody','detail_Template',msg);
   suffixPages(msg,'totalsize','paginateList');
}


//当输入时模糊查询
function onInputChange(){

   if (191 == event.keyCode && event.altKey) {
      var curpagno=1;
      var colsname=$("#colsname").val();
      var colsccmt=$("#colsccmt").val();

      var data={
         colsname:colsname,
         colsccmt:colsccmt,
         curpagno:curpagno,
         pagesize:"8"
      };
      ajaxPost("baseDeclareControl/blurredQuery.req",data,"blurredQueryCallBack");
   }


}

function onSelectChange(){
   var colstype= $("#colstype").val();
   if(colstype=="EnumType"){
      layer_show('枚举字典','enum-declare.html','900','660');
   }
}

//键盘按下Tab事件
function myKeyDown(){
   var keyname= event.keyCode;
   if(keyname==9){
      $("#colsname")[0].focus();
   }
}

//增加字段声明回掉
function addWordBookCallBack(msg){
   location.reload();
}

//增加字段声明
function addWordBook(){
   var data={
      colsname:$("#colsname").val(),
      colsccmt:$("#colsccmt").val(),
      colslenh:$("#colslenh").val(),
      colstype:$("#colstype").val()
   };
   ajaxPost("baseDeclareControl/addWordBook.req",data,"addWordBookCallBack");
}

