<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>게시글 수정</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
  </head>
  <body>
    <h1>${boardVO.id}번 게시글 수정</h1>
    <form
      method="post"
      enctype="multipart/form-data"
      action="/board/modify/${boardVO.id}">
      <div class="grid">
        <label for="subject">제목</label>
        <input
          id="subject"
          type="text"
          name="subject"
          value="${boardVO.subject}" />
        <label for="email">이메일</label>
        <input id="email" type="email" name="email" value="${boardVO.email}" />
        <label for="file">첨부파일</label>
        <div>
          <input id="file" type="file" name="file" />
          현재 업로드 된 파일 : ${boardVO.originFileName}
        </div>
        <label for="content">내용</label>
        <textarea id="content" name="content">${boardVO.content}</textarea>

        <div class="btn-group">
          <div class="right-align">
            <input type="submit" value="저장" />
          </div>
        </div>
      </div>
    </form>
  </body>
</html>
