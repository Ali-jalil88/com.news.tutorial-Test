package com.zyadeh.kamel.command.impl2;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.exceptions.ServiceException;

public class Main {
    public static void main(String[] args) {
        Command command = new AuthorDeleteCommand();
        try {
            command.execute(null);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
