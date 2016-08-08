package model.core;

import java.util.HashMap;
import java.util.Map;

import model.InvoiceModel;

public class InvoicesImpl implements InvoicesModel {

    private Map<Integer,InvoiceModel> invoice = new HashMap<Integer,InvoiceModel>();
}
