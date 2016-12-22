package com.lg.service;

import com.lg.core.web.JsonData;

public interface ISysRoleResourceService{

    public JsonData insertBatch(String roleId,String resourceIds);
    
    public JsonData deleteByRoleId(String roleId);
}
