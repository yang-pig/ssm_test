package com.ssmtest.entity;

public class Nav {

    private long id;
    private long tid;
    private String link;
    private String sort;
    private String name;
    private String time;
    private short blank;
    private short status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTid() {
        return tid;
    }

    @Override
    public String toString() {
        return "Nav{" +
                "id=" + id +
                ", tid=" + tid +
                ", link='" + link + '\'' +
                ", sort='" + sort + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", blank=" + blank +
                ", status=" + status +
                '}';
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public short getBlank() {
        return blank;
    }

    public void setBlank(short blank) {
        this.blank = blank;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }


}