<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>Register</title>
    <style type="text/css">
      .form {
        margin: 0 auto;
      }
      .button-register {
        background-color: green;
        color: white;
      }
      .button-report {
        background-color: #000000;
        color: white;
      }
    </style>
  </head>
  <body>
    <div class="form">
      <h2>CRUD APP</h2>
      <a href="read"
        ><button class="button-report" type="button">Read</button></a
      >
      <s:form action="create.action" method="post">
        <s:textfield label="Id" name="id" />
        <s:textfield label="Description" name="description" />

        <s:submit cssClass="button-register" value="Create" />
      </s:form>
      <s:if test="ctr>0">
        <span style="color: green"><s:property value="msg" /></span>
      </s:if>
      <s:else>
        <span style="color: red"><s:property value="msg" /></span>
      </s:else>
    </div>
  </body>
</html>
