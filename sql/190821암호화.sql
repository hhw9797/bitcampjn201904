SELECT * FROM project.member;

    drop table member;
    
    commit;

-- 단방향 함수
select 
	upw, password(upw) as password,
    sha2(upw, 256) as sha2,
    sha2(upw, 512) as sha3,
    sha1(upw) as sha1,
    sha(upw) as sha,
    md5(upw) as md5    
from project.member limit 0,1
;

-- 암호화
update project.member set upw= hex(aes_encrypt(upw, 'password'))
where idx=29
;

-- 복호화
select upw, convert(aes_decrypt(UNHEX(upw), 'password') using utf8) as upw
from project.member
where idx=29
;
    
    create table member (
idx int(20) auto_increment,
uId varchar(50),
uPw varchar(50) NOT NULL,
uName varchar(50) NOT NULL,
uPhoto varchar(50),
regDate datetime default current_timestamp,
primary key(uId),
unique key m_auto_increment_test_idx01(idx)
)engine = innoDB default char set=utf8;


