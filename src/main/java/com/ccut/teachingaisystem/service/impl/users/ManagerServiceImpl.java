package com.ccut.teachingaisystem.service.impl.users;

import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.dao.LogDao;
import com.ccut.teachingaisystem.dao.users.UsersDao;
import com.ccut.teachingaisystem.domain.log.OperationLog;
import com.ccut.teachingaisystem.domain.users.Managers;
import com.ccut.teachingaisystem.domain.users.UserActions;
import com.ccut.teachingaisystem.exception.SystemException;
import com.ccut.teachingaisystem.service.usersService.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final LogDao logDao;

    private final UsersDao usersDao;

    @Autowired
    public ManagerServiceImpl(LogDao logDao, UsersDao usersDao) {
        this.logDao = logDao;
        this.usersDao = usersDao;
    }

    @Override
    public boolean getPassword(Managers managers) {
        try {
            String password = usersDao.selectManagerPasswordByUserName(managers.getUserName());
            return managers.getPassword().equals(password);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<OperationLog> getAllOperationLog() {
        try {
            return logDao.selectOperationLog();
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<UserActions> getAllUserActions() {
        try {
            return usersDao.selectAllUserActions();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }
}
