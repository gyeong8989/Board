<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/main.jsp"><i class="bi bi-house-door " style="font-size:3rem"></i></a>
    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <i class="bi bi-grid-3x3-gap-fill"></i>
    </button>
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item me-5">
          <a class="nav-link active" aria-current="page" href="#">API</a>
        </li>
        <li class="nav-item me-5">
          <a class="nav-link" href="/Notice/list.do">공지사항</a>
        </li>
         <li class="nav-item me-5">
          <a class="nav-link" href="/Board/list.do">게시판</a>
        </li>
      </ul>
      
      <!-- 검색사용  -->
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>