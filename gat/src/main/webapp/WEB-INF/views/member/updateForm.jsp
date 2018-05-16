<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<div class="container">
      <form class="contact-us form-horizontal" method="post">
        <legend>Contact Form</legend>        
        <div class="control-group">
            <label class="control-label">Name</label>
            <div class="controls">
                <div class="input-prepend">
                <span class="add-on"><i class="icon-user"></i></span>
                    <input type="text" class="input-xlarge" name="name" placeholder="Name">
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">Email</label>
            <div class="controls">
                <div class="input-prepend">
                <span class="add-on"><i class="icon-envelope"></i></span>
                    <input type="text" class="input-xlarge" name="email" placeholder="Email">
                </div>
            </div>    
        </div>
        <div class="control-group">
            <label class="control-label">Url</label>
            <div class="controls">
                <div class="input-prepend">
                <span class="add-on"><i class="icon-globe"></i></span>
                    <input type="text" id="url" class="input-xlarge" name="url" placeholder="http://www.example.com">
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">Comment</label>
            <div class="controls">
                <div class="input-prepend">
                <span class="add-on"><i class="icon-pencil"></i></span>
                    <textarea name="comment" class="span4" rows="4" cols="80" placeholder="Comment (Max 200 characters)"></textarea>
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