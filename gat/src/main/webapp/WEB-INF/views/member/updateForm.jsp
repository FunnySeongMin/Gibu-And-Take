<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="container" id="updateForm">
      <form class="contact-us form-horizontal" method="post" action="update.do">
        <legend>회원정보 수정</legend>       
         <div class="control-group">
            <label class="control-label">ID</label>&nbsp;--------------&nbsp;${sessionScope.mvo.id}
            <input type="hidden" name="id" value="${sessionScope.mvo.id}">
        </div>
        <div class="control-group">
            <label class="control-label">Name</label>&nbsp;---------&nbsp;${sessionScope.mvo.name}
        </div>
        <div class="control-group">
            <label class="control-label">Address</label>
            <div class="controls">
                <div class="input-prepend">
                    <input type="text" id="url" class="input-xlarge" name="address" placeholder="${sessionScope.mvo.address}">
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">Email</label>
            <div class="controls">
                <div class="input-prepend">
                    <input type="text" class="input-xlarge" name="email" placeholder="${sessionScope.mvo.email}">
                </div>
            </div>    
        </div>
        <div class="control-group">
          <div class="controls">
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="button" class="btn">Cancel</button>
          </div>    
        </div>
      </form>
</div>