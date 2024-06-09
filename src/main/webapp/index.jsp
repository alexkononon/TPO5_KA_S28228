<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Search Cars</title>
</head>
<body>
<h1>Search Information About Vehicles</h1>
<form action="request-servlet" method="post">
  <label for="type">Select vehicle type:</label>
  <select id="type" name="type" required>
    <option value="personal">personal</option>
    <option value="truck">truck</option>
    <option value="delivery">delivery</option>
    <option value="F1">F1</option>
  </select>
  <button type="submit">Search</button>
</form>
</body>
</html>

