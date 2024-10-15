<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>게시글 작성하기</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
  </head>
  <body>
    <h1>게시글 작성</h1>

    <form method="post" enctype="multipart/form-data">
      <div class="grid">
        <label for="subject">제목</label>
        <input id="subject" type="text" name="subject" />

        <label for="email">이메일</label>
        <input id="email" type="text" name="email" />

        <label for="file">첨부파일</label>
        <input type="file" type="file" name="file" />

        <label for="content">내용</label>
        <textarea id="content" name="content"></textarea>

        <div class="btn-group">
          <div class="right-align">
            <button>저장</button>
          </div>
        </div>
      </div>
    </form>
  </body>
</html>
