package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.Aempruntable;

public class Livre extends Aempruntable {
    private String authorName;
    private String editor;

    public String getauthorName() {
        return authorName;
    }

    public void setauthorName(String authorName) {
        this.authorName = authorName;
    }

    public String geteditor() {
        return editor;
    }

    public void seteditor(String editor) {
        this.editor = editor;
    }
}
