
function languageChange(lang) {
	var path = location.pathname;
	var action = path;
	var action = action + '?lang=' + lang;
	alert(action);
	$('form').attr('action', action);
	$('form').submit();

}

