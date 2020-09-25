<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="../statics/profile.css">
</head>
<body>

<tag:navigator/>

<form action="${pageContext.request.contextPath}/users" method="post">
    <input type="hidden" name="command" value="updatee_user_command">
    <label>
        <input class="first_name" name="first_name" placeholder="first_name">
    </label>
    <label>
        <input class="last_name" name="last_name" placeholder="last_name    ">
    </label>
    <label>
        <input class="login" name="login" placeholder="login">
    </label>
    <label>
        <input class="password" name="password" placeholder="password">
    </label>
    <label>
        <input class="email" name="email" placeholder="email">
    </label>
    <label>
        <input class="role" name="role" placeholder="role">
    </label>
    <div>
        <input type="submit" class= "update" value="Update" placeholder="create">
    </div>
</form>

</body>
</html>