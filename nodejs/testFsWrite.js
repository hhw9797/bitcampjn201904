var fs = require('fs');
// 파일에 저장
fs.writeFile('textData.txt', 'Hello World', function(err) {
    if ( err ) {
    console.error('파일 저장 실패 : ', err);
    return;
    }
    console.log('파일 저장 성공');
});
// 파일에 내용 추가
fs.appendFile('textData.txt', 'Additional data', function(err) {
if ( err ) {
console.error('파일 내용 추가 실패 : ', err);
}
console.log('파일 내용 추가 성공');
});