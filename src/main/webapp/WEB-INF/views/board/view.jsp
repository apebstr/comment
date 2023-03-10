<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri ="http://java.sun.com/jsp/jstl/functions" %>   

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(document).ready(function() {
	$('#list').click(function(){
		$('#frm').attr('action', 'list.do').submit();
	});	
	
	$('#answer').click(function(){
		$('#frm').attr('action', 'write.do').submit();
	});
	
	$('#update').click(function(){
		$('#frm').attr('action', 'update.do').submit();
	});
	
	$('#delete').click(function(){
		$('#frm').attr('action', 'delete.do').submit();
	});
	

	$('#btnComSend').on('click',process);
});

console.log('jquery');

	function process() {
		$.ajax({
			type : 'POST',
			dataType : 'text',
			data : {comContent:$('#comContent').val()},
			url : 'view.do?currentPage=${currentPage}&num=${dto.num}',
			success : viewMessage
		});
		console.log($('#comContent').val());
	};

	function viewMessage(res) {
		$('#commentView').html(res);
		console.log("viewMessage");
	};
</script>

<div class="container">
	<table class="table  table-bordered">
		<tr>
			<th width="20%">작성자</th>
			<td >${dto.membersDTO.memberName}</td>
			<th width="20%" >조회수</th>
			<td>${dto.readcount}</td>
		</tr>

		<tr>
			<th >제목</th>
			<td colspan="3">${dto.subject}</td>
		</tr>

		<tr>
			<th>내용</th>
			<td colspan="3" >${dto.content}</td>
		</tr>

		<tr>
			<th>파일</th>  
			<td colspan="3"><c:if test="${!empty dto.upload}">
					<a href="contentdownload.do?num=${dto.num}">
						${fn:substringAfter(dto.upload,"_")} </a>
				</c:if> <c:if test="${empty dto.upload }">
					<c:out value="첨부파일 없음" />
				</c:if></td>
		</tr> 
	</table>
	
	<div id="comment">
         <tr>
            <th>덧글</th>
            <td colspan="3">
            <textarea name="comContent" id="comContent" rows="3" style="width:100%" ></textarea></td>
         </tr>
		<input type ="button" value="등록" id="btnComSend"/>
		<div id="commentView"></div>
	</div>
	
   <div class="text-center mt-5 mb-5">
		<form name="frm" id="frm" method="get">
			<input type="hidden" name="num" value="${dto.num}" /> 
			<input type="hidden" name="currentPage" id="currentPage" value="${currentPage}" /> 
			
			<c:if test="${dto.ref != 0}">
				<input type="hidden" name="ref" value="${dto.ref}" /> 
				<input type="hidden" name="re_step" value="${dto.re_step}" /> 
				<input type="hidden" name="re_level" value="${dto.re_level}" /> 
			</c:if>
			
			<input type="button" id="list" 	value="리스트" />		   
			<input type="button" id="answer" value="답변" />
			<c:if test="${sessionScope.authInfo != null && sessionScope.authInfo.memberEmail==dto.memberEmail}">		
				<input type="button" id="update" value="수정" /> 
				<input type="button" id="delete" value="삭제" />
			</c:if>
		</form>
	</div>
</div>