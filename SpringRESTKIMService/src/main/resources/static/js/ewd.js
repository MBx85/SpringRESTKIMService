function ReplaceElementById(theUrl, elementID) {
    var main = document.getElementById(elementID);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
            main.innerHTML = xmlHttp.responseText;
    }
    xmlHttp.open("GET", theUrl, true); // true for asynchronous 
    xmlHttp.send(null);
}

function MakeChildrenInvisibleExceptForOne(ParentDivId, VisibleExceptionId) {
    var selector = "#" + ParentDivId;
    var selectorExceptionId = "#" + VisibleExceptionId;
    $(selector).children('div').css('display', 'none');
    $(selector).children(selectorExceptionId).removeAttr('style');
}

function chk() {
    $("#ServiceVersion").val("LLL");
}

function ReplaceElementByIdDynamicUrl(baseUrl, additionalPath, elementID) {
    ReplaceElementById(baseUrl + additionalPath, elementID);
}

function ReplaceElementByIdDynamicUrlByInfo(baseUrl, elementID, input) {
    var additionalPath = document.getElementById(input).value;
    ReplaceElementByIdDynamicUrl(baseUrl, additionalPath, elementID);
}

function RefreshKims() {
    var date = document.getElementById("date_input").value;
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) { }
        //main.innerHTML = xmlHttp.responseText;
    }
    xmlHttp.open("GET", "/RefreshFromPS?date=" + date, true); // true for asynchronous 
    xmlHttp.send(null);
}

function SaveRestService() {
    var service = new Object();
    service.id = document.getElementById("ServiceID").value;
    service.endpoint = document.getElementById("ServiceEndpoint").value;
    service.version = document.getElementById("ServiceVersion").value;
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("PUT", "/REST/Services/" + service.id, true); // true for asynchronous 
    xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlHttp.send(JSON.stringify(service));
}

function GetAllRestServices(callback) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) { }
        callback(xmlHttp.responseText);
    }
    xmlHttp.open("GET", "/REST/Services", true);
    xmlHttp.send(null);
}

function PopulateServicesDropdown() {
    GetAllRestServices(WriteServiceIDsToDropdown);
}

function WriteServiceIDsToDropdown(response) {
    var dropdown = document.getElementById("ServiceIdSelect");
    while (dropdown.firstChild) {
        dropdown.removeChild(dropdown.firstChild);
    }
    var arr = JSON.parse(response);

    dropdown.appendChild(document.createElement("option"));
    for (i = 0; i < arr.length; i++) {
        var opt = document.createElement("option");
        var ServiceId = arr[i].id;
        opt.value = ServiceId;
        opt.innerHTML = ServiceId;
        dropdown.appendChild(opt);
    }
}

function alertDate() {
    alert(a);
}