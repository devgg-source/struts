<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>Update</title>
  </head>
  <body>
    <h2>Struts 2 Create, Read, Update and Delete (CRUD) Example using JDBC</h2>
    <form action="updatedetails" method="post">
      <pre>
<b>Id:         </b><input type="text" name="id" value='<s:property value="id"/>'>
		
		
<b>Description:        </b><input type="text"  name="description" value='<s:property value="description"/>'>
		            

		<button name="submitType" value="update" type="submit">Update</button>
		</pre>
    </form>
    <s:if test="ctr>0">
      <span style="color: red"><s:property value="msg" /></span>
    </s:if>
    <s:else>
      <span style="color: green"><s:property value="msg" /></span>
    </s:else>
    <a href="read"><button type="button">Record</button></a>
  </body>
</html>
