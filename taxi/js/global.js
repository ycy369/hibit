//后台服务器端的地址
var serverAddress  ="http://127.0.0.1:8080";

//获得浏览器中缓存的用户信息
var account = sessionStorage.getItem("account");

var id = sessionStorage.getItem("id");

//获得session id
var JSESSIONID = sessionStorage.getItem("JSESSIONID");//sessionid 