<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ include file="include/header.jsp" %>
<section class="hero is-primary">
    <div class="hero-body">
        <div class="container">
            <h1 class="title">
                Primary title
            </h1>
            <h2 class="subtitle">
                Primary subtitle
            </h2>
        </div>
    </div>
</section>
<div class="container" style="margin-top: 30px">
    <div class="tile is-ancestor">
        <div class="tile is-vertical is-8">
            <div class="tile">
                <div class="tile is-parent is-vertical">
                    <article class="tile is-child box">
                        <p class="subtitle is-marginless" style="padding-left: 6px">인기글 게시판</p>
                        <hr style="margin: 10px 0px 0px 0px">
                        <table class="table is-fullwidth is-narrow is-striped">
                            <tbody>
                                <tr>
                                    <td><a href="#">안녕하세요</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">안녕하세요</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">안녕하세요</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">안녕하세요</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">안녕하세요</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </article>
                    <article class="tile is-child box">
                        <!-- Put any content you want -->
                    </article>
                </div>
                <div class="tile is-parent">
                    <article class="tile is-child box">
                        <!-- Put any content you want -->
                    </article>
                </div>
            </div>
            <div class="tile is-parent">
                <article class="tile is-child box">
                    <!-- Put any content you want -->
                </article>
            </div>
        </div>
        <div class="tile is-parent">
            <article class="tile is-child box">
                <!-- Put any content you want -->
            </article>
        </div>
    </div>
</div>
<%@ include file="include/footer.jsp" %>