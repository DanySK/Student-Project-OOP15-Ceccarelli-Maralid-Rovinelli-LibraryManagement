package main;
import model.EmployeeModel;
import model.StreamImpl;
import model.StreamModel;
import view.MainView;
import view.MainViewImpl;

import java.awt.Window;

import controller.Controller;
import controller.Controller;
public class Main {

    public static void main(String[] args) {
        StreamImpl<EmployeeModel,EmployeeModel> employeeModel = new StreamImpl<EmployeeModel,EmployeeModel>();
        Controller c = new Controller(employeeModel);
        MainView v = new MainViewImpl();
        c.setView(v);
        ((Window) v).setVisible(true);
    }

}
