<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	var chk = ${rCnt};
	if(chk>0){
		alert('가입되었습니다. 메일 인증을 해주세요.');
		location.href='../main';
	} else {
		alert('회원가입이 되지 않았습니다. 관리자에 연락바랍니다.');
		location.href='../main';
	}
</script>