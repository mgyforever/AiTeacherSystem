package com.ccut.teachingaisystem.service.usersService;

import com.ccut.teachingaisystem.domain.log.OperationLog;
import com.ccut.teachingaisystem.domain.users.Managers;

import java.util.List;

public interface ManagerService {
    boolean getPassword(Managers managers);
    List<OperationLog> getAllOperationLog();
}
