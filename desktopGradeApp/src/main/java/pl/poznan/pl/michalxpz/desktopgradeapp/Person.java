package pl.poznan.pl.michalxpz.desktopgradeapp;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class Person extends Button implements Comparable {

    private Integer grade = 0;
    private String name = null;

    public Person() {
    }

    public Person(String name, Integer grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass() == this.getClass()) {
            Person comp = (Person) o;
            if (comp.getGrade() < grade) return 1;
            else return -1;
        } else
            return -1;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
