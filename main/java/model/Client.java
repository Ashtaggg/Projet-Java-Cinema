package model;

public class Client {
    private int id;
    private String name;
    private String email;
    private boolean isMember;

    public Client() {
        // Constructeur par défaut
    }

    public Client(int id, String name, String email, boolean isMember) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isMember = isMember;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }
}
