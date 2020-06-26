$(document).ready(function() {
	 $('#datetimepicker1').datetimepicker({
		 format: 'L'
	 });

	$('[id^="userFileTemp"]').each(function(i, elem) {
		if($(this).val() != '') {
			$(this).prev().prev('.custom-file-label').html($(this).val());
		}
	});


//	$('.custom-file-input').on('change',function(){
//	    $(this).next('.custom-file-label').html($(this)[0].files[0].name);
//	})
//	//ファイルの取消
//	$('.reset').click(function(){
//	    $(this).parent().prev().children('.custom-file-label').html('ファイル選択...');
//	    $('.custom-file-input').val('');
//	})

	$('.custom-file-input').on('change', handleFileSelect);
	function handleFileSelect(evt) {

	    var fileSize = $(this)[0].files[0].size;


	    // 10MB制限
	    if(fileSize > 10*1024*1024) {
	    	// modal表示
	    	$('fileSizeModal').modal('show');

	    } else {
    		// label設定
	    	$(this).next('.custom-file-label').html($(this)[0].files[0].name);

    		var id = $(this).next().next().next().attr('id');
	    	// TempFile保存
	    	uploadTempFile($(this)[0].files[0], id);
	    }
	}

	//ファイルの取消
	$('.reset').click(function(){
		// modal表示
		// 初期メッセージ
		var message = $(this).parent().prev().children('.custom-file-label').data("message");
	    $(this).parent().prev().children('.custom-file-label').html(message);
	    $(this).parent().prev().children('.custom-file-input').val('');
	})


	//モーダルの中の「ボタン1」を押した時の処理
	$("#modal01-ok").on('click', function() {
		$('form').attr('action', '/user/save');
		$('form').attr('target', '');
		$('form').submit();
	});

//	$("form").submit(function() {
//
//	})

	//show.bs.modal ： モーダルが開くとき (showメソッドを呼び出し時)
	//shown.bs.modal ： モーダルが完全に表示されたとき
	//hide.bs.modal ： モーダルが閉じるとき (hideメソッドを呼び出し時)
	//hidden.bs.modal ： モーダルが完全に閉じたとき
//	$('#sampleModal').on('hidden.bs.modal', function (event) {
//	});
})



// 臨時ファイル保存
function uploadTempFile(uploadFile, id) {
//	var beforeUrl = $("#tempFileUrl" + fileNum).val();

	var formData = new FormData();
	formData.append("file", uploadFile);
//	formData.append("action_name", actionName);
//	formData.append("before_url", beforeUrl);

	$.ajax({
		type: "POST",
		enctype: 'multipart/form-data',
		url: "/user/saveTempFile",
		data: formData,
		cache: false,
        processData: false,
        contentType: false,
	}).done(function(data) {
		// 成功:true
		// 失敗:false
		$("#" + id).val(uploadFile.name);
	});
}



