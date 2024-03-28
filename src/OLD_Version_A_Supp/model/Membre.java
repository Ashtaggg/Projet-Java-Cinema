package src.OLD_Version_A_Supp.model;

public class Membre extends Client {
    private String membershipType;

    public Membre() {
        // Constructeur par défaut
    }

    public Membre(int id, String name, String email, boolean isMember, String membershipType) {
        super(id, name, email, isMember);
        this.membershipType = membershipType;
    }

    // Getter et setter pour membershipType
    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}
