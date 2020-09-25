<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>about</title>
    <link rel="stylesheet" href="../statics/contact.css">
</head>
<body>
    <tag:navigator/>
    <section class="page">

    <h1>
        Contact Us
    </h1>
    <map name="">
        <area shape="" coords="" href="" alt="">
    </map>
    <div class="texts">
        <p class="first_paragraph">
            Drop Us A Message
        </p>
        <p class="second_paragraph">
            Dont hesitate to get in touch. well get back to you as soon as possible
        </p>
        <p class="third_paragraph">
            Belarus, Minsk, Biady4 B.1 R.711B
        </p>
        <p class="fourth_paragraph">
            + 375 25 542 21 25
        </p>
        <p class="fifth_paragraph">
            contactingEmail.com
        </p>
        <section class="container">
            <form action="${pageContext.request.contextPath}/users" method="post">
                <input type="hidden" name="command" value="">
                <label>
                    Name:
                    <input class="name" name="name">
                </label>
                <label>
                    Email:
                    <input class="email" name="email">
                </label>
                <label>
                    Subject:
                    <input class="subject" name="subject">
                </label>
                <label>
                    Message:
                    <textarea class="message" name="message"></textarea>
                </label>
                <label>
                    <input type="submit" class="send_message" name="contacting" value="send message">
                </label>
            </form>
        </section>
    </div>
    <tag:fotter/>
</section>

</body>
</html>