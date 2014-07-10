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
public class Faq {
    private int id;
    private String question;
    private String respones;

    public Faq() {
    }

    @Override
    public String toString() {
        return "Faq{" + "id=" + id + ", question=" + question + ", respones=" + respones + '}';
    }

    public Faq(String question, String respones) {
        this.question = question;
        this.respones = respones;
    }

    public Faq(String question, String respones, int id) {
        this.question = question;
        this.respones = respones;
        this.id = id;
    }

    public Faq(int id, String question, String respones) {
        this.id = id;
        this.question = question;
        this.respones = respones;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRespones() {
        return respones;
    }

    public void setRespones(String respones) {
        this.respones = respones;
    }
    
    
}
