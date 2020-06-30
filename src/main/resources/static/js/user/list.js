$(document).ready(function() {

	//モーダルの中の「ボタン1」を押した時の処理
	$("#search").on('click', function() {
		$('form').attr('action', '/user/search');
		$('form').attr('target', '');
		$('form').submit();
	});

	// ソート変更
	$("#sort").on('change', function() {
		location.href = "/user/paging?sort=" + $(this).val();
	});

	//show.bs.modal ： モーダルが開くとき (showメソッドを呼び出し時)
	//shown.bs.modal ： モーダルが完全に表示されたとき
	//hide.bs.modal ： モーダルが閉じるとき (hideメソッドを呼び出し時)
	//hidden.bs.modal ： モーダルが完全に閉じたとき
//	$('#sampleModal').on('hidden.bs.modal', function (event) {
//	});
})



