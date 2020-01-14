//全局回调
function callback(msg,callNme) {
	if(callNme=="thisOnLoadCallBack"){
		thisOnLoadCallBack(msg);
	}else if(callNme=="onSelectDetailsChangeCallBack"){
		onSelectDetailsChangeCallBack(msg);
	}
}

//加载页面信息
function thisOnLoad(){
	var data={};
	ajaxPost("projectParamControl/queryProjectMsg.req",data,"thisOnLoadCallBack");
}
//加载页面信息回调
function thisOnLoadCallBack(msg){

	$("#dbusrnme").html("dbusrnme");
	$("#dbpaswrd").html("dbusrnme");
	$("#dbdriver").html("dbusrnme");
	$("#dblnkurl").html("dbusrnme");
	$("#prjtpath").html("dbusrnme");
	$("#bscolpth").html("dbusrnme");
	$("#bseumpth").html("dbusrnme");
	$("#excpnpth").html("dbusrnme");
	$("#maprpath").html("dbusrnme");
	$("#mxmlpath").html("dbusrnme");
	$("#entypath").html("dbusrnme");
}

//删除项目清除项目信息
function clearProject() {

}
//重新定位项目
function onProjectChange(){

}

//获取锁定月份记录
function findLockMonth(){
	var date=new Date;
	var year = date.getFullYear();
	var lyear=year-1;
	var nyear=year+1;
	var str="<option value=\""+lyear+"\">"+lyear+"年</option>"+
		"<option value=\""+year+"\">"+year+"年</option>"+
		"<option value=\""+nyear+"\">"+nyear+"年</option>";

	$("#selectYear").html(str);

	var data={
		chckFlag:'SELECTED'
	}
	ajaxPost("accountController.findLockMonth.action",data,"findLockMonthCallBack");
}
function findLockMonthCallBack(msg){
	$("#sumsGets").val(msg.lockMonth.sumsGets);
	var month=msg.lockMonth.tranDate.substring(5,7);
	var year=msg.lockMonth.tranDate.substring(0,4);
	$("#tranDate").val(month);
	$("#selectYear").val(year);
}

//编辑明细
function accountEdit(flag) {
	if(flag==""||flag==null){
		flag=$("#flag").val();
	}
	var data={
		flag:flag,
		colsNumb:$("#colsNumb").val(),
		fileName:$("#fileName").val(),
		fileType:$("#fileType").val(),
		tranDate:$("#tranDate").val(),
		tranType:$("#tranType").val(),
		tranObjt:$("#tranObjt").val(),
		tranGood:$("#tranGood").val(),
		tranDict:$("#tranDict").val(),
		tranAmts:$("#tranAmts").val(),
		paytNums:$("#paytNums").val(),
		itemType:$("#itemType").val(),
		gropType:$("#gropType").val()
	}
	ajaxPost("accountController.accountDetailEdit.action",data,"accountDetailEditCallBack");

}
function accountDetailEditCallBack(msg){
	var index=parent.layer.getFrameIndex(window.name);
	parent.location.reload();
	parent.layer.close(index);
}

//修改总金额本月月份
function sumgetsSave(){
	var tranDate=$("#selectYear").val()+"-"+$("#tranDate").val()+"-01";
	var data={
		tranDate:tranDate,
		sumsGets:$("#sumsGets").val()
	}
	ajaxPost("accountController.sumgetsSave.action",data,"sumgetsSaveCallBack");
}
function sumgetsSaveCallBack(msg){
	var index=parent.layer.getFrameIndex(window.name);
	parent.location.reload();
	parent.layer.close(index);
}

//分析本月数据
function analysData() {
	var data={
		tranDate:$("#tranDate").val()
	}
	ajaxPost("accountController.analysisData.action",data,"analysisDataCallBack");
}

function analysisDataCallBack(msg){
	layer.msg('分析完成。',{icon: 6,time:1000});
	location.reload();
}


//修改补录页面加载
function accounteditLoad(){
	var colsNumb=RequestParameter()["colsNumb"];
	if(colsNumb==null||colsNumb==""){
		$("#flag").val("ADD");
		return;
	}else{
		$("#colsNumb").val(colsNumb);
		$("#flag").val("UPD");
	}
	var data={
		colsNumb:colsNumb
	}
	ajaxPost("accountController.selectDetail.action",data,"accounteditLoadCallBack");
}
function accounteditLoadCallBack(msg) {
	$("#fileName").val(msg.myList[0].fileName);
	$("#fileType").val(msg.myList[0].fileType);
	$("#tranDate").val(msg.myList[0].tranDate+" "+msg.myList[0].tranTime);
	$("#tranType").val(msg.myList[0].tranType);
	$("#tranObjt").val(msg.myList[0].tranObjt);
	$("#tranGood").val(msg.myList[0].tranGood);
	$("#tranDict").val(msg.myList[0].tranDict);
	$("#tranAmts").val(msg.myList[0].tranAmts);
	$("#paytNums").val(msg.myList[0].paytNums);
	$("#itemType").val(msg.myList[0].itemType);
	$(".select").val(msg.myList[0].gropType);
}

//打开修改补录页面
function toOpenEdit(title,url,w,h){
	obj = document.getElementsByName("myChecbox");
	check_val = [];
	for(k in obj){
		if(obj[k].checked){
			check_val.push(obj[k].value);
		}
	}
	if(check_val.length<=0){
		layer.confirm('未选择明细确认是要补录？',function(index){
			layer.close(index);
			layer_show(title,url,w,h);
		});
	}else if(check_val.length>1){
		layer.msg('选择明细大于1条请确认要修改明细！',{icon: 5,time:2000});
	}else{
		url=url+"?colsNumb="+check_val[0];
		layer_show(title,url,w,h);
	}
}

//加载明细数据
function accountDetailsLoad(){
	var date=new Date;
	var year = date.getFullYear();
	var lyear=year-1;
	var nyear=year+1;
	var str="<option value=\""+lyear+"\">"+lyear+"年</option>"+
		"<option value=\""+year+"\">"+year+"年</option>"+
		"<option value=\""+nyear+"\">"+nyear+"年</option>";

	$("#myYear").html(str);
	var data= {}
	ajaxPost("accountController.findDetailsByCondition.action",data,"findDetailsByConditionCallBack");
}
function findDetailsByConditionCallBack(msg){
	$("#myItemType").val(msg.itemType);
	var myMonths=msg.tranDate.substring(5,7);
	var myYear=msg.tranDate.substring(0,4);
	$("#myMonths").val(myMonths);
	$("#myYear").val(myYear);

	innerHtmlForTemplate('myTbody','detail_Template',msg);
	table_refurbish();
}
//按照条件筛选账单明细
function onSelectDetailsChange(){
	var itemType=$("#myItemType").val();
	var myMonths=$("#myMonths").val();
	var myYear=$("#myYear").val();
	var tranDate=myYear+"-"+myMonths+"-01";
	var data= {
		tranDate:tranDate,
		itemType:itemType
	}
	ajaxPost("accountController.onSelectDetailsChange.action",data,"onSelectDetailsChangeCallBack");
}
function onSelectDetailsChangeCallBack(msg) {
	location.replace(location.href);
}

//获取路径
function  getLocalPath(pageId) {
	var data= {
		pageId:pageId
	}
	ajaxPost("publicContriller.getLocalPath.action",data,"getLocalPathCallBack");
}
function  getLocalPathCallBack(msg) {
	$("#url").val(msg.filePath);
}

//导入账单
function  impAccount() {
	var data= $("#form-account-impdp").serialize();
	ajaxPost("accountController.impdpAccount.action",data,"impAccountCallBack");
}
function  impAccountCallBack(msg) {
	if(msg.result=="sucess"){
		var index=parent.layer.getFrameIndex(window.name);
		parent.location.reload();
		parent.layer.close(index);
	}else{
		layer.msg('导入失败：'+msg.result,{icon: 5,time:2000});
	}
}