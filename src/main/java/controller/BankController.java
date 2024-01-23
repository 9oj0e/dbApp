package controller;

/*
* responsibility :
* check validity
* and parse it.
* find appropriate DAO.
* */

import dao.BankDAO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BankController {
    // controller tower
    private BankDAO dao;

    public void insert() {
        System.out.println("controller : insert");
        dao.insert("1234", 1000);
    }

    public void delete() {
        System.out.println("controller : delete");
        dao.deleteByNum(1);
    }

    public void update() {
        System.out.println("controller : update");
        dao.updateByNum(1000, 1);
    }

    public void selectOne() {
        System.out.println("controller : selectOne");
        dao.selectByNum(1);
    }

    public void selectAll() {
        System.out.println("controller : selectAll");
        dao.selectAll();
    }
}
