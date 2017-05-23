<%-- 
    Document   : contactForm
    Created on : Apr 17, 2017, 9:49:03 PM
    Author     : Hai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="toHead.jsp"/>
<jsp:include page="headToContent.jsp"/>
                <div class="formTable"> 
                    <h2 style="text-align: center" >Contact Me</h2>
                    <form name="myForm" method="post" action="http://www.temple.edu/cgi-bin/mail?tug25055@temple.edu" >
                         <label for="userName">Name</label>  <br/>
                         <input type="text" id="userName" name="userName" placeholder="John Smith" required/>  <br/> 
                         <label for="email">Email</label>    <br/>
                         <input type="email" id="email" name="email" placeholder="test123@gmail.com" required/>  <br/>
                         <label for="userSex">Sex</label>    <br/>
                         <input type="radio" id="userSex" name="userSex" value="M"  />   Male    
                         <input type="radio" name="userSex"  value="F"  />    Female  <br/> 
                         <label for='selection'>How did you hear about us?</label>  &nbsp;
                         <select id=selection name="selection" >
                             <option value="v1" >Friends</option>
                             <option value="v2">Family</option>
                             <option value="v3">Newspaper</option>
                             <option value="v4">Search Engine</option>
                             <option value="v5" selected="selected">Email</option>
                             <option value="None">Other</option>
                         </select>     <br/>
                         <label for="rate">Rate Us</label>   <br/>
                         <input type="number" id="rate" name="rate" min="0" max="10"/>     <br/>
                         Are you interested joining our company? <input type="checkbox" name="isCisMajor"  />  <br/> 
                         Comments/Questions?: (optional) <br/>
                         <textarea name="inputcomments" cols="45" rows="5" id="textArea">Type your comments here</textarea> <br/> <br/>
                         <input type="submit" value="Click Here" class="formButton"/>
                     </form>
                </div>

<jsp:include page="postContent.jsp"/>