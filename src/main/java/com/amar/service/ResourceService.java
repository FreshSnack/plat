package com.amar.service;

import com.amar.domain.Resource;
import com.amar.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dingmx
 * @date 2018/8/13 00:50
 */
@Service
public class ResourceService {

    /**
     * 根据角色编码获取资源列表
     * @param roleCode 角色编码
     * @return 资源列表
     */
    public List<Resource> listResourceByRoleCode(String roleCode) {
        return null;
    }

    /**
     * 根据角色列表获取资源列表
     * @param listRole 角色列表
     * @return
     */
    public List<Resource> listResourceByRoleList(List<Role> listRole) {
        return null;
    }
}
