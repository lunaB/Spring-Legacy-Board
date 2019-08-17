<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="include/header.jsp" %>
<section class="hero is-primary">
    <div class="hero-body">
        <div class="container">
            <h1 class="title">
            	다용도 커뮤니티 입니다.
            </h1>
            <h2 class="subtitle">
                단시간 개발시를 위해 틀을 잡는 용도로 만들었습니다.
            </h2>
        </div>
    </div>
</section>
<c:if test="${ success eq true }">
	<div class="notification is-success container" style="margin-top: 10px;">
	  <button class="delete"></button>
	  성공적으로 게시가 완료되었습니다.
	</div>
</c:if>
<div class="container" style="margin-top: 40px;">
    <div class="tabs" style="margin-bottom: 15px;">
        <ul>
            <li class="is-active"><a>모든 게시글</a></li>
            <li><a>인기 게시물</a></li>
            <li><a>갤러리</a></li>
            <li><a>500자 이상</a></li>
            <li><a href="/board/register">게시물 작성</a></li>
        </ul>
    </div>
    <form action="/board/list" method="GET">
	    <div class="field has-addons has-addons-left">
		  <p class="control">
		    <span class="select is-small">
		      <select name="searchType">
		        <option value="n" <c:out value="${ searchCriteria.searchType == null ? 'selected' : '' }"/>>검색종류</option>
		        <option value="t" <c:out value="${ searchCriteria.searchType eq 't' ? 'selected' : '' }"/>>제목</option>
		        <option value="c" <c:out value="${ searchCriteria.searchType eq 'c' ? 'selected' : '' }"/>>내용</option>
		        <option value="w" <c:out value="${ searchCriteria.searchType eq 'w' ? 'selected' : '' }"/>>작성자</option>
		        <option value="tc" <c:out value="${ searchCriteria.searchType eq 'tc' ? 'selected' : '' }"/>>제목+내용</option>
		      </select>
		    </span>
		  </p>
		  <p class="control">
		    <input class="input is-small" style="width: 320px" type="text" placeholder="검색어 입력" name="keyword" value="${ searchCriteria.keyword }">
		  </p>
		  <p class="control">
		    <button class="button is-primary is-small" type="submit">
		      검색
		    </button>
		  </p>
		</div>
	</form>
    <div style="padding-top: 5px">
	    <table class="table is-fullwidth is-narrow is-striped">
	        <thead>
	            <tr>
	                <td style="width:5%">#</td>
	                <td style="width:65%">재목</td>
	                <td style="">작성자</td>
	                <td style="">작성일</td>
	                <td style="">조회수</td>
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach items="${ list }" var="boardVO">
	            <tr>
	                <td>${ boardVO.bno }</td>
	                <td><a href="/board/read/${ boardVO.bno }">${ boardVO.title }</a></td>
	                <td>${ boardVO.writer }</td>
	                <td><fmt:formatDate pattern="yy-MM-dd HH:mm" value="${ boardVO.regdate }" /></td>
	                <td>${ boardVO.viewcnt }</td>
	            </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	    <nav class="pagination is-small" role="navigation" aria-label="pagination">
		  <c:if test="${ pageMaker.prev }">
		  	<a href="/board/list/${ pageMaker.startPage - 1 }?${ pageMaker.searchQuery() }" class="pagination-previous">PREV</a>
		  </c:if>
		  <c:if test="${ pageMaker.next }">
		  	<a href="/board/list/${ pageMaker.endPage + 1 }?${ pageMaker.searchQuery() }" class="pagination-next">NEXT</a>
		  </c:if>
		  <ul class="pagination-list">
		  	<c:forEach begin="${ pageMaker.startPage }" end="${ pageMaker.endPage }" var="idx">
		  		<li><a href="/board/list/${ idx }?${ pageMaker.searchQuery() }" class="pagination-link<c:out value="${ pageMaker.pageCriteria.page == idx ? ' is-current' : '' }"/>">${ idx }</a></li>
		  	</c:forEach>
		  </ul>
		</nav>
    </div>
</div>
<%@ include file="include/footer.jsp" %>