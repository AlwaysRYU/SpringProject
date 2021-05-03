package RYU.selfSpring.domain;

public class Member {

    private Long id;
    private String name;
    // 이름

    //Getter Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
