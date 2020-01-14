//全局回调
function callback(msg,callNme) {
	if(callNme=="thisOnLoadCallBack"){
		thisOnLoadCallBack(msg);
	}else if(callNme=="createProjectCallBack"){
		createProjectCallBack(msg);
	}
}

//加载页面信息
function thisOnLoad(){
	var data={};
	ajaxPost("projectParamControl/queryProjectMsg.req",data,"thisOnLoadCallBack");
}

//加载页面信息回调
function thisOnLoadCallBack(msg){
	var prjtsel=""
	if(msg.prjtlist!=null){
		for(k in msg.prjtlist){
			if(msg.prjtlist[k]==msg.belgprjt){
				prjtsel=prjtsel+"<option value=\""+msg.prjtlist[k]+" \" selected>"+msg.prjtlist[k]+"</option>"
			}else{
				prjtsel=prjtsel+"<option value=\""+msg.prjtlist[k]+" \">"+msg.prjtlist[k]+"</option>"
			}
		}
	}

	var modlsel=""
	if(msg.modllist!=null){
		for(k in msg.modllist){
			if(msg.modllist[k]==msg.belgmodl){
				modlsel=modlsel+"<option value=\""+msg.modllist[k]+" \"selected>"+msg.modllist[k]+"</option>"
			}else{
				modlsel=modlsel+"<option value=\""+msg.modllist[k]+" \">"+msg.modllist[k]+"</option>"
			}
		}
	}

	$("#dbusrnme").html(msg.dbusrnme);
	$("#dbpaswrd").html(msg.dbpaswrd);
	$("#dbdriver").html(msg.dbdriver);
	$("#dblnkurl").html(msg.dblnkurl);
	$("#prjtpath").html(msg.prjtpath);
	$("#bscolpth").html(msg.bscolpth);
	$("#bseumpth").html(msg.bseumpth);
	$("#excpnpth").html(msg.excpnpth);
	$("#maprpath").html(msg.maprpath);
	$("#mxmlpath").html(msg.mxmlpath);
	$("#entypath").html(msg.entypath);
	$("#belgmodl").html(modlsel);
	$("#belgprjt").html(prjtsel);
}

//新增项目
function createProject(){
	var dbusrnme=$("#dbusrnme").val();
	var dbpaswrd=$("#dbpaswrd").val();
	var	dbdriver=$("#dbdriver").val();
	var	dblnkurl=$("#dblnkurl").val();
	var	prjtpath=$("#prjtpath").val();
	var	bscolpth=$("#bscolpth").val();
	var	bseumpth=$("#bseumpth").val();
	var	excpnpth=$("#excpnpth").val();
	var	maprpath=$("#maprpath").val();
	var	mxmlpath=$("#mxmlpath").val();
	var	entypath=$("#entypath").val();
	var	belgmodl=$("#belgmodl").val();
	var	belgprjt=$("#belgprjt").val();

	var data={
		"dbusrnme":dbusrnme,
		"dbpaswrd":dbpaswrd,
		"dbdriver":dbdriver,
		"dblnkurl":dblnkurl,
		"prjtpath":prjtpath,
		"bscolpth":bscolpth,
		"bseumpth":bseumpth,
		"excpnpth":excpnpth,
		"maprpath":maprpath,
		"mxmlpath":mxmlpath,
		"entypath":entypath,
		"belgmodl":belgmodl,
		"belgprjt":belgprjt
	};
	ajaxPost("projectParamControl/createProject.req",data,"createProjectCallBack");
}

//新增项目回调
function createProjectCallBack() {
	var index=parent.layer.getFrameIndex(window.name);
	parent.location.reload();
	parent.layer.close(index);
}

//修改项目
function updateProject(){

}


//删除项目清除项目信息
function clearProject() {

}
//重新定位项目
function onProjectChange(){

}
