package Abiturient;

public class Abiturient {
    private int id;
    private String name;
    private String surName;
    private String secondName;
    private String address;
    private String phone;
    private double averageMark;

    public Abiturient(int id, String name, String surName, String secondName, String address, String phone, float averageMark) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.secondName = secondName;
        this.address = address;
        this.phone = phone;
        this.averageMark = averageMark;

        System.out.println("Object created");
        System.out.println(this.toString());
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String setName(String name){
        return this.name = name;
    }

    public String getSurname() {
        return this.surName;
    }

    public String setSurname(String surname){
        return this.surName = surName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String setSecondName(String secondName){
        return this.secondName = secondName;
    }

    public String getAddress() {
        return this.address;
    }

    public String setAddress(String address){
        return this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public String setPhone(String phone){
        return this.phone = phone;
    }

    public double getAverageMark() {
        return this.averageMark;
    }

    public double setAverageMark(double averageMark){
        return this.averageMark = averageMark;
    }

    public String toString() {
        return "Abiturient{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", surname='" + this.surName + '\'' +
                ", secondName='" + this.secondName + '\'' +
                ", address='" + this.address + '\'' +
                ", phone='" + this.phone + '\'' +
                ", averageMark=" + this.averageMark +
                '}';
    }
}


