$('.custom-file-input').on('change', handleFileSelect);
function handleFileSelect(evt) {
        $('#preview').remove();// 繰り返し実行時の処理
        $(this).parents('.input-group').after('<div id="preview"></div>');

  var files = evt.target.files;

    var output = [];
    for (var i = 0, f; f = files[i]; i++) {
        output.push('<li>', escape(f.name), ' (', f.size, ' bytes)</li>');
    }
    $('#preview').append('<ul>' + output.join('') + '</ul>');

    $(this).next('.custom-file-label').html(+ files.length + '個のファイルを選択しました');
}


//ファイルの取消
$('.reset').click(function(){
    $(this).parent().prev().children('.custom-file-label').html('ファイル選択...');
    $('#preview').remove();
    $('.custom-file-input').val('');
})