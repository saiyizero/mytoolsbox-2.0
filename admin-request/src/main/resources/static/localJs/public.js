//取消弹出层
function layer_cancel(){
	var index=parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}

//ajax 通信方法回调
function callback(msg,callNme) {
	alert('ajax callback');
}

function cleartextArea(htmlid) {
	$("#"+htmlid).text("");
}

//ajax post通信方法
function ajaxPost(url,data,callNme) {
	$.ajax({
		url :url,
		data:data,
		type:"post",
		dataType: "json",
		success : function(msg) {
			callback(msg,callNme);
		}
	});
}
function ajaxAsync(url,data) {
	$.ajax({
		url :url,
		data:data,
		type:"post",
		async:false,
		dataType: "json",
		success : function(msg) {
		}
	});
}
function ajaxAsyncCallBack(url,data,callNme) {
	$.ajax({
		url :url,
		data:data,
		type:"post",
		async:false,
		dataType: "json",
		success : function(msg) {
			callback(msg,callNme);
		}
	});
}


//隐藏id
function hide(id){
	var id1="iframe_"+id;
	$("#"+id1).hide();
	var id2="url_"+id;
	$("#"+id2).removeAttr("data-href");
}
//显示id
function show(id){
	var id1="iframe_"+id;
	$("#"+id1).show();
	var id2="url_"+id;
	var url=id+".html";
	$("#"+id2).attr("data-href",url);
}

//加载菜单列表
function menuLoad(){
	var data = {
		htmlname:"index.html",
		temlname:"menu_Template",
		innerdiv:"myMenuList"
	};
	coreAdapter.exec("public.menuLoad",data);
}


function loadJs(file){
    var head = $("head").remove("script[role='reload']");
    $("<scri"+"pt>"+"</scr"+"ipt>").attr({ 
    role:'reload',src:file,type:'text/javascript'}).appendTo(head);
}

//刷新页面
function html_refurbish(htmlname){
	var data = {htmlname:htmlname};
	coreAdapter.exec("public.htmlRefurbish",data);
}

//弹出全屏窗口
function layerHtml_Full(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

function appendTemplate(innerdiv,temlname,data){
	var div = template(temlname, data);
	$('#'+innerdiv).append(div); 
}

//将表单写入页面中
function innerHtmlForTemplate(innerdiv,temlname,data){
	var html = template(temlname, data);	
	document.getElementById(innerdiv).innerHTML = html;	
}

//对数据分页
function table_refurbish(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "asc" ]],
		"bStateSave": true,
		"aLengthMenu": [[8, 10, 25, -1], [8, 10, 25, "所有"]]
	});
}

//讲表单转换为对象
function serializeFormToObject(form){
	var data={};
	var tform = $(form).serializeArray();
    $.each(tform, function() {
    	data[this.name] = this.value;
    });
	return data;
}
//获取加载页面时传入参数
function RequestParameter(){
	var url = window.location.search;
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		var strs = str.split("&");
		for(var i = 0; i < strs.length; i ++) {
			theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
		}
	}
	return theRequest
}

//拼写分页页面
function suffixPages(msg,totalid,pageid){
	var curpagnos=msg.pagedata.curpagno;
	var totalpags=msg.pagedata.totalpag;
	var totalnums=msg.pagedata.totalnum;
	var totalstr="当前第 "+curpagnos+" 页 ，总计 "+totalpags+"页 ，共 "+totalnums+" 条";

	var pagelists=msg.pagedata.pagelist;
	var pagestr="";

	for(var i=0;i<pagelists.length;i++){
		var pageName = pagelists[i].pageName;
		var pageNo =pagelists[i].pageNo;
		if(pageName=="上一页"){
			pagestr=pagestr+"<a class=\"paginate_button previous disabled\" aria-controls=\"DataTables_Table_0\" " +
				"data-dt-idx=\"0\" tabindex=\"0\" id=\"DataTables_Table_0_previous\" onclick=\"onchangePages("+pageNo+")\">上一页</a>"
		}else if(pageName=="下一页"){
			pagestr=pagestr+"<a class=\"paginate_button next\" aria-controls=\"DataTables_Table_0\" " +
				"data-dt-idx=\"0\" tabindex=\"0\" id=\"DataTables_Table_0_previous\" onclick=\"onchangePages("+pageNo+")\">下一页</a>"
		}else if(pageName=="..."){
			pagestr=pagestr+"<span>...</span>";
		}else{
			if(pageNo==curpagnos){
				pagestr=pagestr+"<a class=\"paginate_button current\" aria-controls=\"DataTables_Table_0\" " +
					"data-dt-idx=\"1\" tabindex=\"0\" onclick=\"onchangePages("+pageNo+")\">"+pageName+"</a>";
			}else{
				pagestr=pagestr+"<a class=\"paginate_button\" aria-controls=\"DataTables_Table_0\" " +
					"data-dt-idx=\"1\" tabindex=\"0\" onclick=\"onchangePages("+pageNo+")\">"+pageName+"</a>";
			}
		}
	}

	$("#"+totalid).html(totalstr);
	$("#"+pageid).html(pagestr);
}