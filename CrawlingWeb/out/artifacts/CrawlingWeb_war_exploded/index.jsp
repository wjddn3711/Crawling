<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE HTML>
<!--
Spectral by HTML5 UP
html5up.net | @ajlkn
Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
  <title>FashCom</title>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
  <link rel="stylesheet" href="assets/css/main.css" />
  <noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
</head>
<body class="landing is-preload">

<!-- Page Wrapper -->
<div id="page-wrapper">

  <!-- Header -->
  <header id="header" class="alt">
    <h1><a href="index.jsp">FashCom</a></h1>
    <nav id="nav">
      <ul>
        <li class="special">
          <a href="#menu" class="menuToggle"><span>Menu</span></a>
          <div id="menu">
            <ul>
              <li><a href="index.html">Home</a></li>
              <li><a href="learn.html">Learn More</a></li>
              <li><a href="elements.html">Elements</a></li>
              <li><a href="#">Sign Up</a></li>
              <li><a href="#">Log In</a></li>
            </ul>
          </div>
        </li>
      </ul>
    </nav>
  </header>

  <!-- Banner -->
  <section id="banner">
    <div class="inner">
      <h2>fashcom</h2>
      <p>Find Most Suitable suit,<br />
        All clothes info <br />
        provided by <a href="https://store.musinsa.com/app/">Musinsa</a>.</p>
      <ul class="actions special">
        <li><a href="#" class="button primary">Sign-Up</a></li>
<%--        회원가입 페이지로 이동--%>
      </ul>
    </div>
    <a href="#three" class="more scrolly">Learn More</a>
  </section>


  <!-- Three -->
  <section id="three" class="wrapper style3 special">
    <div class="inner">
      <header class="major">
        <h2>Used Stack</h2>
        <p>자바 기반의 jsoup을 활용한 웹 크롤링을 이용하여 현재 탑 랭킹 의류들을 제공합니다</p>
      </header>
      <ul class="features">
        <li class="icon fa-paper-plane">
          <h3>Server</h3>
          <p>Tomcat 9.0.54</p>
        </li>
        <li class="icon solid fa-laptop">
          <h3>Used Libraries</h3>
          <p>mysql-connector-java-5.1<br>jsoup-1.14.3<br>apache-tomcat-9.0.54</p>
        </li>
        <li class="icon solid fa-code">
          <h3>Code</h3>
          <p>Java 기반의 JSP</p>
        </li>
        <li class="icon fa-flag">
          <h3>Goal</h3>
          <p>다른 쇼핑몰들의 크롤링을 통하여<br> 종합 랭킹을 구현</p>
        </li>
      </ul>
    </div>
  </section>

  <!-- CTA -->
  <section id="cta" class="wrapper style4">
    <div class="inner">
      <header>
        <h2>made process</h2>
        <p>Learn more 를 통해 과정을 살펴보세요</p>
      </header>
      <ul class="actions stacked">
        <li><a href="#" class="button fit primary">Sign-Up</a></li>
        <li><a href="learn.html" class="button fit">Learn More</a></li>
      </ul>
    </div>
  </section>

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