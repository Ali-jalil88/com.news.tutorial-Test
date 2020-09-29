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
public class RoleUpdateCommand implements Command {
    private final RoleService service;
@Autowired
    public RoleUpdateCommand(RoleService service) {
        this.service = service;
    }

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Role role = service.read(3);
        role.setRole("trail");
        service.update(role);
        return null;
    }
}
