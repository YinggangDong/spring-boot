package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * DateTestVO 类是
 *
 * @author dongyinggang
 * @date 2022-01-19 16:06
 **/
@Data
public class DateTestVO {

    private String string;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;

    private LocalDate localDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime localDateTime;
}
