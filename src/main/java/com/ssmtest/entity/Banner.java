package com.ssmtest.entity;

public class Banner {
    private long id;

    private String apic;
    private String atitle;
    private String alink;

    private String bpic;
    private String btitle;
    private String blink;

    private String cpic;
    private String ctitle;
    private String clink;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApic() {
        return apic;
    }

    public void setApic(String apic) {
        this.apic = apic;
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle;
    }

    public String getAlink() {
        return alink;
    }

    public void setAlink(String alink) {
        this.alink = alink;
    }

    public String getBpic() {
        return bpic;
    }

    public void setBpic(String bpic) {
        this.bpic = bpic;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBlink() {
        return blink;
    }

    public void setBlink(String blink) {
        this.blink = blink;
    }

    public String getCpic() {
        return cpic;
    }

    public void setCpic(String cpic) {
        this.cpic = cpic;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public String getClink() {
        return clink;
    }

    public void setClink(String clink) {
        this.clink = clink;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", apic='" + apic + '\'' +
                ", atitle='" + atitle + '\'' +
                ", alink='" + alink + '\'' +
                ", bpic='" + bpic + '\'' +
                ", btitle='" + btitle + '\'' +
                ", blink='" + blink + '\'' +
                ", cpic='" + cpic + '\'' +
                ", ctitle='" + ctitle + '\'' +
                ", clink='" + clink + '\'' +
                '}';
    }
}