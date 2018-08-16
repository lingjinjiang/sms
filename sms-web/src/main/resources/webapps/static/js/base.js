function getUrlParam(){
	var search = location.search.substr(1);
	var searchArray = search.split("&");
	var searchObj = {};
	for(var i=0;i<searchArray.length;i++){
		var newSearch = searchArray[i].split('=');
		searchObj[decodeURIComponent(newSearch[0])] = decodeURIComponent(newSearch[1]);
	}
	return searchObj;
}