Login 까지 구현한 Shopping에
dbms 접근할 때에 mybatis 사용

root-context.xml에서 import jdbc-config.xml 하는 부분에서 자꾸 에러 나던 것
원인 -> jdbc-config.xml 파일에서의 오타 혹은 jdbc-config.xml 파일 인식 불가
해결법 -> 제대로 확인 못했는데, jdbc-config.xml 파일 삭제하고 새로 만든 후 되는 사람 코드 복사해서 하니 됨
오타!!! 파일 재생성!!
