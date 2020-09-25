<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="khgkjgkjhgkjhgkj">
    <title>Home</title>
    <link rel="stylesheet" href="<c:url value="/statics/tags/register_tag.css"/>">
</head>
<body>
<div class="flag">
    <div class="fronter">

        <form action="${pageContext.request.contextPath}/users" method="post">

            <div>
                <label for="firstName"></label>
                <input type="text" id="firstName" name="firstName" placeholder="firstName" required/>
            </div>

            <div>
                <label for="lastName"></label>
                <input type="text" id="lastName" name="lastName" placeholder="lastName" required/>
            </div>

            <div>
                <label for="login"></label>
                <input type="text" id="login" name="login" placeholder="login" required/>
            </div>

            <div>
                <label for="password"></label>
                <input type="password" id="password" name="password" placeholder="password" required/>
            </div>

            <div>
                <label for="email"></label>
                <input type="text" id="email" name="email" placeholder="email" required/>
            </div>

            <div>
                <label for="role"></label>
                <input type="text" id="role" name="role" placeholder="role" required/>
            </div>

            <input type="hidden" name="command" value="command_register"/>

            <div>
                <input type="submit" name="register" value="Register">
            </div>
        </form>

    </div>
</div>
<div class="divider_div">
    <p class="divider">
        Avone is evaluated as my most unique Multi-Concept eCommerce Shopify Theme for shop online with clean and modern design.</p>
</div>
</body>
</html>