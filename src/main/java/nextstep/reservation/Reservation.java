package nextstep.reservation;

import lombok.Getter;
import lombok.ToString;
import nextstep.schedule.Schedule;

@Getter
@ToString
public class Reservation {
    private Long id;
    private Schedule schedule;
    private String username;

    public Reservation() {
    }

    public Reservation(Schedule schedule, String username) {
        this.schedule = schedule;
        this.username = username;
    }

    public Reservation(Long id, Schedule schedule, String username) {
        this.id = id;
        this.schedule = schedule;
        this.username = username;
    }
}
