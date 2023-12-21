//--------------------VIP start------------------------
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) return c.substring(name.length,c.length);
    }
    return "";
}
function hasVip() {
    var user = getCookie("auth");
    if (user=="" || user=="591f53a4-62c5-43ff-893d-2acb2f76d3fe") {
        return false;
    } else {
        return true;
    }
}
//--------------------VIP end------------------------
