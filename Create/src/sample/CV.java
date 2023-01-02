package sample;



import java.util.ArrayList;
import java.util.List;

public class CV {

    private String name;
    private String surname;
    private String jobTitle;

    public String x;
    public String y;
    private int id;
    private List list;
    private String attributeName;
    private String attributeValue;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String a;
    public String b;
    public String c;

    ArrayList<String> attrName;
    ArrayList<String> attrvalue;

    public ArrayList<String> getAttrName() {
        return attrName;
    }

    public void setAttrName(ArrayList<String> attrName) {
        this.attrName = attrName;
    }

    public ArrayList<String> getAttrvalue() {
        return attrvalue;
    }

    public void setAttrvalue(ArrayList<String> attrvalue) {
        this.attrvalue = attrvalue;
    }

    public CV(String name, String surname,String jobTitle, ArrayList<String> attrName, ArrayList<String> attrvalue){

        this.name=name;
        this.surname=surname;

        this.jobTitle=jobTitle;
        this.attrName=attrName;
        this.attrvalue=attrvalue;
    }

    public CV(){

    }

    public CV(int id, String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }


    public CV(List list) {
        this.list = list;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public CV(String x, String y) {
        this.x = x;
        this.y = y;

    }




    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}




