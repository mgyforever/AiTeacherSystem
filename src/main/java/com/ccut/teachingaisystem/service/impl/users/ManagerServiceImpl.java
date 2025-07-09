package com.ccut.teachingaisystem.service.impl.users;

import com.ccut.teachingaisystem.dao.users.UsersDao;
import com.ccut.teachingaisystem.domain.users.Managers;
import com.ccut.teachingaisystem.service.usersService.ManagerService;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    private final UsersDao usersDao;

    public ManagerServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public boolean getPassword(Managers managers) {
        try {
            String password = usersDao.selectManagerPasswordByUserName(managers.getUserName());
            return managers.getPassword().equals(password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
