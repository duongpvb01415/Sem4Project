/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.da.access;

/**
 *
 * @author Windows
 */
public class Home {
    private int id;
    private String logo;
    private String slide;
    private String title;
    private String content1;
    private String content2;
    private String content3;
    private String rootUpload;
    public int getId() {
        return id;
    }

    public String getRootUpload() {
        return rootUpload;
    }

    public void setRootUpload(String rootUpload) {
        this.rootUpload = rootUpload;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Home() {
    }

    @Override
    public String toString() {
        return "Home{" + "id=" + id + ", logo=" + logo + ", slide=" + slide + ", title=" + title + ", content1=" + content1 + ", content2=" + content2 + ", content3=" + content3 + '}';
    }

    public Home(String logo, String title, String content1, String content2, String content3, String rootUpload) {
        this.logo = logo;
        this.title = title;
        this.content1 = content1;
        this.content2 = content2;
        this.content3 = content3;
        this.rootUpload = rootUpload;
    }

    public Home(String rootUpload, int id) {
        this.rootUpload = rootUpload;
        this.id = id;
    }

    public Home(int id, String slide) {
        this.id = id;
        this.slide = slide;
    }

    public Home(String slide) {
        this.slide = slide;
    }

    
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSlide() {
        return slide;
    }

    public void setSlide(String slide) {
        this.slide = slide;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }
    
    
    
}
