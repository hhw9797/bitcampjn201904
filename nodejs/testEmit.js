// 자바스크립트 객체 생성

var obj = {};
obj.name = 'HAN';
obj.hello = function(){
    console.log(this.name);
};

obj.hello();

var Person = function(){
}
// 공용 메서드 정의
Person.prototype.sayhello = function(){
    console.log('안녕하세요');
}

class Member {
}

var member = new Member();

//person.sayhello();

// 상속처리를 위한 util 모듈 로드
var util = require('util');

// 이벤트 등록을 위한 EventEmitter 생성
var EventEmitter = require('events').EventEmitter

// 상속 Person에 EventEmitter 상속
util.inherits(Person, EventEmitter);

// Person 객체 생성
var person = new Person();
// 이벤트 등록
person.on('hi', function(){
    console.log('안녕하세용 반갑습니당');
});

// 이벤트 발생
person.emit('hi');