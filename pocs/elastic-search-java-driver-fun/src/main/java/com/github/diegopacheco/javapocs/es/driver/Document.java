package com.github.diegopacheco.javapocs.es.driver;

import java.util.Objects;

public class Document {

    private String id;
    private String index;
    private String content;

    public Document(){}

    public Document(String id, String index, String content) {
        this.id = id;
        this.index = index;
        this.content = content;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id) && Objects.equals(index, document.index) && Objects.equals(content, document.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, index, content);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", index='" + index + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
