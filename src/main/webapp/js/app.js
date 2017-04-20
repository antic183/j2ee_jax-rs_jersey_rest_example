(function($) {
	$(document).ready(function() {
		$(document).on('submit', '#myForm', function(e) {
			e.preventDefault();

//			form = $(this);
//			data = form.serializeJSON();
//			var file = $('input[name="file"]').get(0).files[0];
//			var formData = new FormData();
//			formData.append('file', file);

//			$.ajax({
//				url : form.attr('action'),
//				type : "Post",
//				cache : false,
//				dataType : "Json",
//				contentType : "multipart/form-data",
//				processData : false,
//				data : formData,
//				success : function(res) {
//					console.info("it works! " + res);
//				},
//				fail : function(err) {
//					console.error(err);
//				}
//			});

			$(this).ajaxSubmit(function(res){
				console.info(res);
			});
		});
	});
})(jQuery);
