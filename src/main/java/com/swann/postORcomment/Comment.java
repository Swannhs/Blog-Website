package com.swann.postORcomment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comment {
    @Id
    private String comment;

    public Comment() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
