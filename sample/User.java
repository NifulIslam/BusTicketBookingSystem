package sample;

import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public String type;
    public int[] tickets= new int[5];
    public User(String type) {
        this.type = type;
    }

    public User(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
