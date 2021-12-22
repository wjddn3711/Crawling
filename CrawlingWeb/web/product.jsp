<%--
  Created by IntelliJ IDEA.
  User: jungwoo
  Date: 2021/12/15
  Time: 3:24 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<!--
Spectral by HTML5 UP
html5up.net | @ajlkn
Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
    <title>Elements - Spectral by HTML5 UP</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
</head>
<body class="is-preload">

<!-- Page Wrapper -->
<div id="page-wrapper">

    <!-- Header -->
    <header id="header">
        <h1><a href="main.do">FASHCOM</a></h1>
        <nav id="nav">
            <ul>
                <li class="special">
                    <a href="#menu" class="menuToggle"><span>Menu</span></a>
                    <div id="menu">
                        <ul>
                            <li><a href="main.do">Home</a></li>
                            <li><a href="learn.jsp">Learn More</a></li>
                            <li><a href="elements.html">Elements</a></li>
                            <mytag:login/>
                            <mytag:productList/>
                        </ul>
                    </div>
                </li>
            </ul>
        </nav>
    </header>

    <!-- Main -->
    <article id="main">
        <header>
            <h2>Fashcom</h2>
            <p>Musinsa 크롤링 리스트</p>
        </header>

        <section class="wrapper style5">
            <div class="inner">
                <form method="post" action="search.do">
                    <div class="row gtr-uniform">
                        <div class="col-6 col-12-xsmall">
                            <input type="text" name="keyword" placeholder="검색어를 입력하세요" required/>
                        </div>
                        <div class="col-6 col-12-xsmall">
                            <input type="submit" value="search">
                        </div>
                    </div>
                </form>
                <div class="table-wrapper">
                    <table>
                        <thead>
                            <tr>
                                <th >Ranking</th>
                                <th >Name</th>
                                <th >Brand</th>
                                <th >Price</th>
                                <th >image</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${datas}" var="v">
                                <tr>
                                    <td>${v.ranking}</td>
                                    <td>${v.name}</td>
                                    <td>${v.brand}</td>
                                    <td>${v.price}</td>
                                    <td><img src="${v.image}"></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
    </article>

    <!-- Footer -->
    <footer id="footer">
        <ul class="icons">
            <li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
            <li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
            <li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
            <li><a href="#" class="icon brands fa-dribbble"><span class="label">Dribbble</span></a></li>
            <li><a href="#" class="icon solid fa-envelope"><span class="label">Email</span></a></li>
        </ul>
        <ul class="copyright">
            <li>&copy; Untitled</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
        </ul>
    </footer>

</div>

<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.scrollex.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/browser.min.js"></script>
<script src="assets/js/breakpoints.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>

</body>
</html>