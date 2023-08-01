package com.dmdk.common.config;


import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;

import static java.time.temporal.ChronoField.*;

public class JSR310DateFormatterUtil {

    public static final DateTimeFormatter NG_UI_LOCAL_DATE;
    public static final DateTimeFormatter NG_UI_LOCAL_TIME;
    public static final DateTimeFormatter NG_UI_LOCAL_DATE_TIME;

    public static final DateTimeFormatter DEFAULT_LOCAL_DATE_TIME;

    static {
        DEFAULT_LOCAL_DATE_TIME =DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN);

        NG_UI_LOCAL_DATE = new DateTimeFormatterBuilder()
                .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                .appendLiteral('-')
                .appendValue(MONTH_OF_YEAR, 1, 2, SignStyle.NOT_NEGATIVE)
                .appendLiteral('-')
                .appendValue(DAY_OF_MONTH, 1, 2, SignStyle.NOT_NEGATIVE)
                .toFormatter();

        NG_UI_LOCAL_TIME = new DateTimeFormatterBuilder()
                .appendValue(HOUR_OF_DAY, 1, 2, SignStyle.NOT_NEGATIVE)
                .appendLiteral(':')
                .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NOT_NEGATIVE)
                .optionalStart()
                .appendLiteral(':')
                .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
                .optionalStart()
                .appendFraction(NANO_OF_SECOND, 0, 9, true)
                .toFormatter();

        NG_UI_LOCAL_DATE_TIME = new DateTimeFormatterBuilder()
                .appendOptional(new DateTimeFormatterBuilder()
                        .parseCaseInsensitive()
                        .append(NG_UI_LOCAL_DATE)
                        .appendLiteral(' ')
                        .append(NG_UI_LOCAL_TIME).toFormatter())
                .appendOptional(new DateTimeFormatterBuilder()
                        .parseCaseInsensitive()
                        .append(NG_UI_LOCAL_DATE)
                        .appendLiteral('T')
                        .append(NG_UI_LOCAL_TIME).toFormatter())
                .toFormatter();
    }

    public static LocalDateTime parse(String text) {
        return NG_UI_LOCAL_DATE_TIME.parse(text, LocalDateTime::from);
    }

    public static LocalDate parseDate(String text) {
        return NG_UI_LOCAL_DATE.parse(text, LocalDate::from);
    }

    public static String format(LocalDateTime dateTime){
        return DEFAULT_LOCAL_DATE_TIME.format(dateTime);
    }

    public static JavaTimeModule createJacksonTimeModule() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DEFAULT_LOCAL_DATE_TIME));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(NG_UI_LOCAL_DATE_TIME));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(DatePattern.NORM_DATE_PATTERN)));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(NG_UI_LOCAL_DATE));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(DatePattern.NORM_TIME_PATTERN)));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(NG_UI_LOCAL_TIME));
        return javaTimeModule;
    }
}
