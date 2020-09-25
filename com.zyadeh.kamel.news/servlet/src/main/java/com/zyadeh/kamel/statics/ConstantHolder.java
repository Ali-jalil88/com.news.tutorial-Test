package com.zyadeh.kamel.statics;

public class ConstantHolder {
    public static final String USER_SELECT = "select * from users";
    public static final String USER_SELECT_BY_ID = "SELECT * FROM users u WHERE u.id = ?";
    public static final String USER_INSERT = "INSERT INTO users (name, last_name, login, password, email) VALUES (?, ?, ?, ?, ?)";
    public static final String USER_UPDATE = "UPDATE users SET name=?, last_name=?, login=?, password=?, email=? WHERE id=?";
    public static final String USER_DELETE = "Delete FROM users WHERE id=?";

    public static final String ROLE_SELECT = "SELECT * FROM roles";
    public static final String ROLE_SELECT_BY_ID = "SELECT * FROM roles r WHERE r.id = ?";
    public static final String ROLE_INSERT = "INSERT INTO roles (id, role) VALUES (?, ?)";
    public static final String ROLE_UPDATE = "UPDATE roles SET role=? WHERE id=?";
    public static final String ROLE_DELETE = "Delete FROM roles where id=?";

    public static final String TAG_SELECT = "SELECT * FROM tags";
    public static final String TAG_SELECT_BY_ID = "SELECT * FROM tags t WHERE t.id = ?";
    public static final String TAG_INSERT = "INSERT INTO tags (name) VALUES (?)";
    public static final String TAG_UPDATE = "UPDATE tags SET name=? WHERE id=?";
    public static final String TAG_DELETE = "Delete FROM tags WHERE id=?";

    public static final String AUTHORS_SELECT = "SELECT * FROM authors";
    public static final String AUTHORS_SELECT_BY_ID = "SELECT * FROM authors a WHERE a.id = ?";
    public static final String AUTHORS_INSERT = "INSERT INTO authors (name, last_name) VALUES (?, ?)";
    public static final String AUTHORS_UPDATE = "UPDATE authors SET name=?, last_name=? WHERE id=?";
    public static final String AUTHORS_DELETE = "Delete FROM authors WHERE id=?";

    public static final String NEWS_SELECT = "SELECT * FROM news";
    public static final String NEWS_SELECT_BY_ID = "SELECT * FROM news n WHERE n.id = ?";
    public static final String NEWS_INSERT = "INSERT INTO news (title, short_text, full_text," +
            "published_in, created_in) VALUES (?, ?, ?, ?, ?)";
    public static final String NEWS_UPDATE = "UPDATE news SET title=?, short_text=?, full_text=?," +
            "published_in=?, created_in=? WHERE id=?";
    public static final String NEWS_DELETE = "Delete FROM news WHERE id=?";

    public static final String IMAGE_SELECT = "SELECT url FROM imgs WHERE news_id = ?";


    public static final String USER_LOGIN = "SELECT * FROM users WHERE login=? AND password=?";
    public static final String AUTHORS_LOGIN = "SELECT * FROM authors WHERE login=? AND password=?";
    public static final String LAST_INSERT = "SELECT currval(pg_get_serial_sequence('%s','id'))";

}
