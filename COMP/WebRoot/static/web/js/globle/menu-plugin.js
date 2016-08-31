function MenuCookie(){
	this.openMenuList = new Array();
	this.closeMenuList = new Array();
}

MenuCookie.prototype.getCurrent = function(){
	return this.current;
}

MenuCookie.prototype.setCurrent = function(current){
	return this.current = current;
}

MenuCookie.prototype.getOpenMenuList = function(){
	return this.openMenuList;
}

MenuCookie.prototype.setOpenMenuList = function(openMenuList){
	return this.openMenuList = openMenuList;
}

MenuCookie.prototype.getCloseMenuList = function(){
	return this.closeMenuList;
}

MenuCookie.prototype.setCloseMenuList = function(closeMenuList){
	return this.closeMenuList = closeMenuList;
}

MenuCookie.prototype.toJson = function(){
	return "{'current':'"+this.current+"','openMenuList':"+this.openMenuList.toJson()+",'closeMenuList':"+this.closeMenuList.toJson()+"}";
}

Array.prototype.toJson = function(){
	var jsonStr = "[";
	for(var i=0;i<this.length;i++){
		jsonStr += "'"+this[i]+"'";
		if(i<this.length-1){
			jsonStr += ",";
		}
	}
	jsonStr += "]";
	return jsonStr;
}

Array.prototype.indexOf = function(val) {
	for (var i = 0; i < this.length; i++) {  
		if (this[i] == val) return i;  
	}  
	return -1;  
}; 

Array.prototype.remove=function(val)
{
	var index = this.indexOf(val);  
	while (index > -1) {  
		this.splice(index, 1);
		index = this.indexOf(val);
	}
} 

$.menuCookie = {
	"cookieName":"menuCookie",
	"menuCookie": new MenuCookie()
};

//展开一个目录
$.menuCookie.init = function(){
	var menuCookieStr = $.cookie(this.cookieName);
	if(menuCookieStr){
		var menuCookieObject = eval("("+menuCookieStr+")");
		this.menuCookie.setCurrent(menuCookieObject.current);
		this.menuCookie.setOpenMenuList(menuCookieObject.openMenuList);
		this.menuCookie.setCloseMenuList(menuCookieObject.closeMenuList);
	}
}

//展开一个目录
$.menuCookie.current = function(menuName){
	$.menuCookie.getMenuCookie().setCurrent(menuName);
	$.menuCookie.save();
}

//展开一个目录
$.menuCookie.open = function(menuName){
	$.menuCookie.getMenuCookie().getOpenMenuList().push(menuName);
	var closeMenuList = $.menuCookie.getMenuCookie().getCloseMenuList();
	closeMenuList.remove(menuName);
	$.menuCookie.save();
}

//收缩一个目录
$.menuCookie.close = function(menuName){
	var openMenuList = $.menuCookie.getMenuCookie().getOpenMenuList();
    openMenuList.remove(menuName);
    var closeMenuList = $.menuCookie.getMenuCookie().getCloseMenuList();
    closeMenuList.push(menuName);
	$.menuCookie.save();
}

//保存菜单数据到cookie中
$.menuCookie.save = function(){
	$.menuCookie.clear();
	$.cookie(this.cookieName,$.menuCookie.getMenuCookie().toJson(), { expires: 7, path: '/' });
}

//保存菜单数据到cookie中
$.menuCookie.clear = function(){
	$.removeCookie(this.cookieName,{ expires: 7, path: '/' });
}

//获取菜单数据
$.menuCookie.getMenuCookie = function(){
	return this.menuCookie;
}
$(function(){
	//初始化menuCookie对象
	$.menuCookie.init();
})


