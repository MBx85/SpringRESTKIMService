function ReplaceElementById(theUrl, elementID) {
    var main = document.getElementById(elementID);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
            main.innerHTML = xmlHttp.responseText;
    }
    xmlHttp.open("GET", theUrl, false); // true for asynchronous 
    xmlHttp.send(null);
}

function ReplaceElementByIdCallback(theUrl, elementID, callback) {
    var main = document.getElementById(elementID);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            main.innerHTML = xmlHttp.responseText;
            callback();
        }
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
    }
    xmlHttp.open("GET", "/RefreshFromPS?date=" + date, true);
    xmlHttp.send(null);
}

function SaveRestService() {
    var service = new Object();
    service.id = $("#ServiceIdSelect option:selected").val();
    service.name = $("#ServiceName").val();
    service.endpoint = $("#ServiceEndpoint").val();
    service.version = $("#ServiceVersion").val();
    /**
     * for every $(".RestFieldInput")
     */
    var RestFields = $(".RestFieldInput").get();
    console.log(RestFields.length);
    for(var i=0;i<RestFields.length;i++){
        console.log(RestFields[i].children()/*.$("#RestFieldValue")*/);
    }

    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("PUT", "/REST/Services/" + service.id, true);
    xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlHttp.send(JSON.stringify(service));
}

function GetAllRestServices(callback) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
            callback(xmlHttp.responseText);
    }
    xmlHttp.open("GET", "/REST/Services", true);
    xmlHttp.send(null);
}

function WriteServiceDetailsToUI(response) {
    var service = JSON.parse(response);
    $("#ServiceVersion").val(service.version);
    $("#ServiceName").val(service.name);
    $("#ServiceEndpoint").val(service.endpoint);
}

function PopulateServiceDetails() {
    var SvcId = $("#ServiceIdSelect option:selected").val();
    GetRestService(SvcId, WriteServiceDetailsToUI);
    WriteServiceDetailsToUI(null);
}

function GetRestService(ServiceId, callback) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
            callback(xmlHttp.responseText);
    }
    xmlHttp.open("GET", "/REST/Services/" + ServiceId, true);
    xmlHttp.send(null);
}

function PopulateServicesDropdown() {
    GetAllRestServices(WriteServiceIDsToDropdown);
}

function WriteServiceIDsToDropdown(response) {
    var dropdown = document.getElementById("ServiceIdSelect")
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

function AddRestField() {
    $(".AddFieldBtnRow").remove();
    $("#RestFieldTableBody").append("<tr class='RestFieldInput'>  <td><input type='text' id='RestFieldValue'></td>  <td><input type='text' id='RestFieldSource'></td>  <td><button id='RemFieldBtn' onclick='RemoveRestField($(this))'>-</button></td></tr>");
    $("#RestFieldTableBody").append("<tr class='AddFieldBtnRow'><td> <button id='AddFieldBtn' onclick='AddRestField()'>+</button></td ></tr>");
}

function RemoveRestField(e) {
    e.parent().parent().remove();
}
