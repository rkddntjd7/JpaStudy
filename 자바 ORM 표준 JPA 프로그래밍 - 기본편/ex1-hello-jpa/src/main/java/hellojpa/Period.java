package hellojpa;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Period {

    //기간 Period
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Period() {
    }


}
