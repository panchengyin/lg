package com.lg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lg.pojo.SysResource;
import com.lg.vo.SysResourceVO;

public interface ISysResourceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);
    
    int deleteByIds(@Param("ids") String[] ids);

    List<SysResourceVO> queryListPage(@Param("id") String id,@Param("search") String txt_search);
    
    List<SysResourceVO> selectTreeList(@Param("roleId") String roleId); 
}