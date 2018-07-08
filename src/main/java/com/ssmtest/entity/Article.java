package com.ssmtest.entity;

public class Article {

    private long id;
    private long tid;
    private String title;
    private short status;
    private String source;
    private String view;
    private String time;
    private String author;
    private short commend;
    private short choice;
    private String pic;
    private String keywords;
    private String description;
    private String content;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public short getCommend() {
        return commend;
    }

    public void setCommend(short commend) {
        this.commend = commend;
    }

    public short getChoice() {
        return choice;
    }

    public void setChoice(short choice) {
        this.choice = choice;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", tid=" + tid +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", source='" + source + '\'' +
                ", view='" + view + '\'' +
                ", time='" + time + '\'' +
                ", commend=" + commend +
                ", choice=" + choice +
                ", pic='" + pic + '\'' +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}