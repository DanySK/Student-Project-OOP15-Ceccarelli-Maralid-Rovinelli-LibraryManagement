package main;
import model.Employee;
import model.IOModel;
import view.MainView;
import view.MainViewImpl;

import java.awt.Window;

import controller.ControllerImpl;
public class Main {

    public static void main(String[] args) {
        IOModel<Employee> employeeModel = new IOModel<>();
        ControllerImpl c = new ControllerImpl();
        MainView v = new MainViewImpl();
        c.setView(v);
        ((Window) v).setVisible(true);
    }

}
