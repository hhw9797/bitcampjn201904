// 1. 모듈 등록
var http = require('http'); // 웹서버 생성 모듈
// 2. 필요한 객체 생성
http.createServer(function(request, response){
    response.writeHead(200, {'Context-Type':'text/html'});
    response.end('<h1> Test Server index Page </h1>');
}).listen(3003);