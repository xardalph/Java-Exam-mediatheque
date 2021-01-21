package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.Aempruntable;

public class Livre extends Aempruntable {
    private String authorName;
    private String editor;

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
