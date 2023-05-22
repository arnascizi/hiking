package io.github.arnascizi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.NotImplementedException;

import java.time.LocalDateTime;
import java.util.Calendar;

@Getter
@AllArgsConstructor
public enum SeasonEnum {

    SPRING,
    SUMMER,
    FALL,
    WINTER,
    ALL;
    public static SeasonEnum resolveSeason(String season) {
        return switch (season) {
            case "SPRING" -> SeasonEnum.SPRING;
            case "SUMMER" -> SeasonEnum.SUMMER;
            case "FALL" -> SeasonEnum.FALL;
            case "WINTER" -> SeasonEnum.WINTER;
            case "ALL" -> SeasonEnum.ALL;
            default -> throw new NotImplementedException("There is no implementation for such season: " + season);
        };
    }

    public static SeasonEnum resolveSeasonFromDate(LocalDateTime dateTime) {
        return switch (dateTime.getMonthValue() - 1) {
            case Calendar.JANUARY, Calendar.FEBRUARY, Calendar.DECEMBER -> WINTER;
            case Calendar.MARCH, Calendar.APRIL, Calendar.MAY -> SPRING;
            case Calendar.JUNE, Calendar.JULY, Calendar.AUGUST -> SUMMER;
            case Calendar.SEPTEMBER, Calendar.OCTOBER, Calendar.NOVEMBER -> FALL;
            default -> throw new IllegalArgumentException("No such month exists! " + dateTime.getMonthValue());
        };
    }
}
