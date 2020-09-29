package com.zyadeh.kamel.command.impl2;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.Role;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Scanner;
@Component("")
public class RoleDeleteCommand implements Command {
    @Autowired
    public RoleDeleteCommand() {
    }

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        RoleService service = new RoleService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter role id: ");
        int id = scanner.nextInt();
        Role role = service.read(id);
        service.delete(role);
        return null;
    }
}
