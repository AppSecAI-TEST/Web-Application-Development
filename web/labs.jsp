<%-- 
    Document   : labs
    Created on : Jan 31, 2017, 1:41:48 PM
    Author     : tug25055
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="toHead.jsp"/>
<jsp:include page="headToContent.jsp"/>
            <div style="padding: 5%">
                <h2 class="labName">Lab 1: Data Model (& Project Proposal)</h2>
                <p class="labDescrip"> A project proposal was created and a database design was created. 
                    <a href=CIS3308_Lab2_Dang_Hai.docx style="text-decoration: none;">Click here</a> for the latest web application proposal.
                    <a href="datamodel.pdf" style="text-decoration: none;">Click here</a> for the data model.</p>
                
                <h2 class="labName">Lab 2: Database (Populate & Extract Data)</h2>
                <p class="labDescrip"> In this lab, the database was populated with values. Then values were extracted with 
                    <a href="CIS3308_Lab2_Dang_Hai.docx" style="text-decoration: none;">SQL statements</a>.</p>
                
                <h2 class="labName">Lab 3: JSP Home Page</h2>
                <p class="labDescrip">For this lab, this website was created using html/css along with select JSP statements for code reuse. Click here to see my 
                <a href="index.jsp" style="text-decoration: none;"> home page</a></p>
                
                <h2 class="labName">Lab 4: Data Display Lab</h2>
                <p class="labDescrip">In the lab, I learned how to write java & JSP code that connected to my database. 
                One of the interesting aspects of this lab was setting up table in the code and formatting it appropriately.
                This was a little challenging because I had to create a few unique formatters in the FormatUtils class for 
                parsing the result set specifically for datatypes of type double and one uniquely for images. 
                Click this link to see my <a href="users.jsp" style="text-decoration: none;"> users page</a>,
                this link to see my <a href="other.jsp" style="text-decoration: none;"> others page</a>,
                or this link to see my <a href="assoc.jsp" style="text-decoration: none;"> associative page</a>.  
                </p>
                
                <h2 class="labName">Lab 5: Logon Lab</h2>
                <p class="labDescrip">The topic of this lab involved the understanding of the REST design philosophy and 
                    implementing data persistence among pages. The easy part of this lab was more of the backend where 
                    it wasn't that hard to write the prepared statement and retrieve the result set given the sample code 
                    and similarity to the last lab. However I found that one problem was with debugging where the errors 
                    displayed on the webpage were somewhat useful but still a challenge to approach. Overall, I really had fun 
                    designing the dynamic ui based on stored session and understanding how this all comes together. 
                </p>
                
                <h2 class="labName">Lab 6: JSP Search</h2>
                <p class="labDescrip">For this lab I learned how to persist data on a form and how to perform a search along 
                    with using prepared statements. Writing the jsp servlet file wasn't too bad considering that it was done 
                    during the lab activity. However an error that I approached was with the order I wrote the prepared 
                    statements before inputting user values which was an easy fix. Another challenging aspect was getting 
                    the user selected value passed from the jsp page to the server since the form only returned the value 
                    in the request so I had to use the form value and match that with the table id on the server side. 
                    Overall, I really had fun this was a very interesting lab. 
                    Click here to see my <a href = "search.jsp" style="text-decoration: none;">search page</a>.
                </p>
                
                <h2 class="labName">Lab 7: Insert Lab</h2>
                <p class="labDescrip">In this lab, I learned how to create an insert into my database and utilized the techniques 
                    I learned from previous weeks to persist my data and pass in selected values. The challenging part for 
                    me was with the associative table. The problem was I wanted to timestamp each transaction at time of
                    submission. Even more difficult was that I also wanted to calculate the total cost of the transaction as 
                    a function of product price multiplied with the quantity ordered. Eventually I figured it out by doing 
                    another call in the backend and returning back the individual price from the other table to be used 
                    for computation. Another difficulty was trying to figure out how to incorporate login into the 
                    associative table and figuring out how to get back that session data. In conclusion, I managed to
                    get all of this to work and I learned a lot.
                    Click this link to see my <a href="insertUser.jsp" style="text-decoration: none;">insertUser.jsp</a>,
                    this link to see my <a href="insertOther.jsp" style="text-decoration: none;">insertOther.jsp</a>,
                    or this link to see my <a href="insertAssoc.jsp" style="text-decoration: none;">insertAssoc.jsp</a>.  
                </p>
                
                <h2 class="labName">Lab 8: Update Lab</h2>
                <p class="labDescrip">For the lab, I made an update feature to my project which was very similar to the last lab. 
                    The challenging part for me was manipulating the the select tag to persist the respective value from the 
                    database. Another part that was hard was getting the double value back as a string value without 
                    the commas. This was actually an easy fix where I just made another formatter which excluded these 
                    commas. Overall the lab was easy considering that the majority of it was done for the lab activity.
                    The frontend work for this lab can be seen in the links below. In order to see the full functionality 
                    of applying the update, navigate to the Customer, Spaceship, or Buys tab and click on the update icon.
                </p>
                <ul>
                    <li><a href="updateUser.jsp" style="text-decoration: none;">updateUser.jsp</a></li>
                    <li><a href="updateOther.jsp" style="text-decoration: none;">updateOther.jsp</a></li>
                    <li><a href="updateAssoc.jsp" style="text-decoration: none;">updateAssoc.jsp</a></li> 
                </ul>
                
                <h2 class="labName">Lab 9: Ajax Search Lab</h2>
                <p class="labDescrip"> In this lab, three web APIs were made for each table in the database from which AJAX 
                    calls were made to get the JSON data back and displayed similar to the search.jsp page.
                    The challenging part of this project was getting the AJAX call to work and the data to persist on the select tag.
                    The fix was for the latter was to obviously not use a form tag at all. The rest of the project was actually very easy
                    due to myself doing this in the other class. In order to see the full functionality of this project, follow the links below.
                </p>
                <ul>
                    <li>User API JSON: <a href="userSelectTag_API.jsp" style="text-decoration: none;">userSelectTag_API.jsp</a></li>
                    <li>Other API JSON: <a href="otherSelectTag_API.jsp" style="text-decoration: none;">otherSelectTag_API.jsp</a></li>
                    <li>Assoc API JSON: <a href="dataSearch_API.jsp" style="text-decoration: none;">dataSearch_API.jsp</a></li> 
                    <li>Ajax Search Page: <a href="search.html" style="text-decoration: none;">search.html</a></li> 
                </ul>
                
                <h2 class="labName">Lab 10: Delete Lab</h2>
                <p class="labDescrip"> For this lab, I had to implement the delete function across all tables.
                    The only challenging part of this project was really figuring out the best way to propogate the error message from the delete function
                    in the DbMods to the browser. An example would be when the page is loaded and the user hasn't clicked on anything. Aside from that,
                    the rest of the project was actually really easy considering that it's very similar to the update lab.
                    In order to view the delete part of this project, look through the links below.
                </p>
                <ul>
                    <li>User Delete: <a href="users.jsp" style="text-decoration: none;">users.jsp</a></li>
                    <li>Other Delete: <a href="other.jsp" style="text-decoration: none;">other.jsp</a></li>
                    <li>Assoc Delete: <a href="assoc.jsp" style="text-decoration: none;">assoc.jsp</a></li> 
                </ul>
            </div>
<jsp:include page="postContent.jsp"/>


