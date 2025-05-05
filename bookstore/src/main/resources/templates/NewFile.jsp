<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Book Store</title>
</head>
<body>
<h1>Bookstore Data</h1>
<table border="1">
<tr>
            <th>Column1</th>
            <th>Column2</th>
            <th>Column3</th>
        </tr>
        <%
        try{
        	// Database connection details
            String url = "jdbc:mysql://localhost:3306/your_database_name";
            String username = "root";
            String password = "Bhargavi@68";

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // SQL query to fetch data
            String query = "SELECT * FROM book1";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
            	
            	%>
                <tr>
                    <td><%= resultSet.getString("column1") %></td>
                    <td><%= resultSet.getString("column2") %></td>
                    <td><%= resultSet.getString("column3") %></td>
                </tr>
                <%
                        }
                        connection.close();
                    } catch (Exception e) {
                        out.println("Error: " + e.getMessage());
                    }
            
       
        %>
</table>

</body>
</html>


               