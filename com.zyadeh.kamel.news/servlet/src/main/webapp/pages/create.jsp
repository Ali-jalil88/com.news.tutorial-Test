<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="../statics/create.css">
</head>
<body>

<tag:navigator/>

<div class="create_body">
    <form action="${pageContext.request.contextPath}/users" method="post">
        <label>
            <input type="submit" name="create" value="Create">
        </label>
        <input type="hidden" name="command" value="create_news_command">
        <label>
            <textarea class="title" name="title" contenteditable="true">title</textarea>
        </label>
        <label>
            <textarea class="short_text" name="short_text" contenteditable="true">short_text</textarea>
        </label>
        <label>
            <textarea class="full_text" name="full_text" contenteditable="true">full_text</textarea>
        </label>
        <div class="sub_section">
            <label>
                <textarea class="created_in" name="created_in" contenteditable="true">created_in</textarea>
            </label>
            <label>
                <textarea class="published_in" name="published_in" contenteditable="true">published_in</textarea>
            </label>
            <label>
                <textarea class="name" name="name" contenteditable="true">author's name</textarea>
            </label>
            <label>
                <textarea class="last_name" name="last_name" contenteditable="true">author's last_name</textarea>
            </label>
        </div>
    </form>
</div>
</body>
</html>