<%--
  Created by IntelliJ IDEA.
  User: jungwoo
  Date: 2021/12/15
  Time: 3:24 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
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
        <h1><a href="index.jsp">FASHCOM</a></h1>
        <nav id="nav">
            <ul>
                <li class="special">
                    <a href="#menu" class="menuToggle"><span>Menu</span></a>
                    <div id="menu">
                        <ul>
                            <li><a href="main.do">Home</a></li>
                            <li><a href="learn.jsp">Learn More</a></li>
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
            <p>Fashcom에 로그인하여 다양한 서비스를 즐겨보세요</p>
        </header>
        <section class="wrapper style5">
            <div class="inner">
                <section>
                    <h4>Log In</h4>
                    <form method="post" action="login.do">
                        <div class="row gtr-uniform">
                            <div class="col-6 col-12-xsmall">
                                ID<input type="text" name="uid" id="demo-name" placeholder="ID를 입력하세요" required/>
                            </div>
                            <div class="col-6 col-12-xsmall">
                                PW<input type="password" name="upw" id="demo-email" placeholder="비밀번호를 입력하세요" required/>

                            </div>
                            <div class="col-6 col-12-xsmall">
                                <input type="submit" value="로그인">
                                <button><a href="new.jsp">회원 가입하기</a></button>
                            </div>
                        </div>
                    </form>
                </section>
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