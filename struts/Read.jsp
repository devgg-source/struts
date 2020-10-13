<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>Report</title>
    <style>
      table,
      td,
      th {
        border: 1px solid black;
      }
      h2{
        text-align: center;
      }
      table {
        border-collapse: collapse;
        width: 60%;
        margin: 0 auto;
      }
      th {
        height: 30px;
      }
      .button-create{
        background-color: green;
        color: white;
        margin-left: 76%;
        margin-top: 5px;
      }
      .button-update {
        background-color: #008cba;
        color: white;
      }
      .button-delete {
        background-color: red;
        color: white;
      }
    </style>
  </head>
  <body>
    <h2>CRUD APP</h2>
    <div style="margin-top: 40px">
      <s:if test="noData==true">
        <table>
          <thead>
            <tr style="background-color: #e0e0e1">
              <th>Id</th>
              <th>Decription</th>
              <th>Role</th>
              <th>Update/Delete</th>
            </tr>
          </thead>
          <s:iterator value="beanList">
            <tr>
              <td><s:property value="id" /></td>
              <td><s:property value="description" /></td>
              <td><s:property value="role "/></td>

              <td>
							<a href="updatedetails.action?submitType=updatedata&id=<s:property value="id"/>">
								<button class="button-update">Update</button>
							</a>
							<a href="deleterecord.action?id=<s:property value="id"/>">
								<button class="button-delete">Delete</button>
              </a>
              
						</td>
            </tr>
          </s:iterator>
        </table>
      </s:if>
      <s:else>
        <div style="color: red">No Data Found.</div>
      </s:else>
      <a href="create.action">
        <button class="button-create" >Create</button>
      </a>
    </div>
  </body>
</html>
