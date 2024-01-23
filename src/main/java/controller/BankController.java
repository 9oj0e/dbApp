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

    @RequestMapping(uri="/insert")
    public void insert() {
        System.out.println("controller : insert");
        dao.insert("12345", 1111);
    }

    @RequestMapping(uri="/delete")
    public void delete() {
        System.out.println("controller : delete");
        dao.deleteByNum(1);
    }

    @RequestMapping(uri="/update")
    public void update() {
        System.out.println("controller : update");
        dao.updateByNum(1000, 1);
    }

    @RequestMapping(uri="/selectOne")
    public void selectOne() {
        System.out.println("controller : selectOne");
        dao.selectByNum(5);
    }

    @RequestMapping(uri="/selectAll")
    public void selectAll() {
        System.out.println("controller : selectAll");
        dao.selectAll();
    }
}
