$(document).ready(function() {
	$('.custom-file-input').on('change',function(){
	    $(this).next('.custom-file-label').html($(this)[0].files[0].name);
	})
	//ファイルの取消
	$('.reset').click(function(){
	    $(this).parent().prev().children('.custom-file-label').html('ファイル選択...');
	    $('.custom-file-input').val('');
	})


//	$.ajax({
//        url : '/testDocWeb/forwardToCallingSystem',
//        type :'POST',
//        data : myObject,
//        cache: false,
//        timeout: 600000,
//        success : function(data) {
//            alert('Data: ' + JSON.stringify(data));
//        },
//        error : function(request,error) {
//            alert("Error : " + JSON.stringify(request));
//        }
//    });

//	$("form").submit(function() {
//	})
})

