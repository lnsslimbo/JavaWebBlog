package com.liu.blog.entity;

public class ArticleType {
    private String articleTypeName;//文章类型名
    private String userName;//用户名

    public ArticleType() {
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
