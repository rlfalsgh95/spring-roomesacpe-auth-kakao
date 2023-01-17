package nextstep.theme;

import lombok.*;

@Getter
@ToString
public class Theme {
    private Long id;
    private String name;
    private String desc;
    private int price;

    public Theme() {
    }

    public Theme(Long id, String name, String desc, int price) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public Theme(String name, String desc, int price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }
}
