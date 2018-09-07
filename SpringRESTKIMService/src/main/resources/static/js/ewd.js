function ReplaceElementById(theUrl,elementID) {
    var main = document.getElementById(elementID);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
            //callback();
            main.innerHTML = xmlHttp.responseText;
    }
    xmlHttp.open("GET", theUrl, true); // true for asynchronous 
    xmlHttp.send(null);
}

function ReplaceElementByIdDynamicUrl(baseUrl,additionalPath,elementID){
    ReplaceElementById(baseUrl+additionalPath,elementID);
}

function ReplaceElementByIdDynamicUrlByInfo(baseUrl,elementID,input){
    var additionalPath = document.getElementById(input).value;
    ReplaceElementByIdDynamicUrl(baseUrl,additionalPath,elementID);
}

function RefreshKims(){
    var date = document.getElementById("date_input").value;
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
            {}
            //main.innerHTML = xmlHttp.responseText;
    }

    xmlHttp.open("GET", "/RefreshFromPS?date="+date, true); // true for asynchronous 
    xmlHttp.send(null);
}

function alertDate(){
    
    alert(a);

}