package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.Aempruntable;

import java.io.Serializable;

public class Livre extends Aempruntable implements Serializable {
    private String authorName;
    private String editor;

    public Livre(String reference, String titre, boolean borrow, String authorName, String editor) {
        super(reference, titre, borrow);
        this.authorName = authorName;
        this.editor = editor;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
}
