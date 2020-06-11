// 無効なフィールドがある場合にフォーム送信を無効にするスターターJavaScriptの例
//(function() {
//	'use strict';
//	window.addEventListener('load', function() {
//		// Fetch all the forms we want to apply custom Bootstrap validation
//		// styles to
//		var forms = document.getElementsByClassName('needs-validation');
//		// Loop over them and prevent submission
//		var validation = Array.prototype.filter.call(forms, function(form) {
//			form.addEventListener('submit', function(event) {
//				if (form.checkValidity() === false) {
//					event.preventDefault();
//					event.stopPropagation();
//				}
//				form.classList.add('was-validated');
//			}, false);
//		});
//	}, false);
//})();

function languageChange(lang) {
	var path = location.pathname;
	var action = path;
	var action = action + '?lang=' + lang;
	alert(action);
	$('form').attr('action', action);
	$('form').submit();

}

