package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@ToString
public class Account {
    private int number;
    private String password;
    private int balance;
    private Timestamp createdAt; // 표기법은 현재 언어의 것을 따른다. "created_at" X
}
