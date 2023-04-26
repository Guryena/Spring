### 트랜잭션 설명
#### 1. 의미
일련의 작업 단위
완전히 처리되거나 All-or-Noting

#### 2. 소프트웨어에서의 트랜잭션 처리
기본적으로 하나의 함수에 묶어서 처리
Spring의 경우 그 기준은 비즈니스 로직을 처리하는 서비스 단에서의 함수로 묶음

#### 3. Spring에서는 기본적으로 함수, 클래스, 인터페이스 위에 @Transactional로 롤백처리
롤백(트랜잭션)은 언제 일어나는가 
>	해당 함수에서 에러, Exception(예외)가 일어났을 때

#### 4. @Transactional 과 Checked, unChecked Exception의 관
예외에 따른 롤백처리는 Checked 예외는 롤백되지 않고, Unchecked 예외는 롤백된다
Checked Exception 일때는 Rollback을 하지 않는다
@Transactional(rollbackFor=Exception.class) 옵션으로 모든 예외에 대해서 롤백할 수 있다

=============================================================================

 기본적으로 @Transactional 은 unChecked Exception 과 error 객체 대상으로 롤백시킴
 Checked Exception도 롤백 시키고 싶으면 , rollbackFor = Exception.class 을 쓰면됨
