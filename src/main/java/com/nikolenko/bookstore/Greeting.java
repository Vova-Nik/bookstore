package com.nikolenko.bookstore;

public class Greeting {
    private final long id;
    private final String content;

    public Greeting() {
        this.id = -1;
        this.content = "";
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        if(content.length()==0)
        {
            return "No name parameter in request. Use http://localhost:8080/rest?name=nammme";
        }

        return "name  " + content + " pressed";
    }
}
