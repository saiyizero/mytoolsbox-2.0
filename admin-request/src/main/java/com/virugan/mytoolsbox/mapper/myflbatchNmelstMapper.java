package com.virugan.mytoolsbox.mapper;

import com.virugan.mytoolsbox.entry.myflbatchNmelst;
import com.virugan.mytoolsbox.entry.myflbatchNmelstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface myflbatchNmelstMapper {
    int countByExample(myflbatchNmelstExample example);

    int deleteByExample(myflbatchNmelstExample example);

    int insert(myflbatchNmelst record);

    int insertSelective(myflbatchNmelst record);

    List<myflbatchNmelst> selectByExample(myflbatchNmelstExample example);

    int updateByExampleSelective(@Param("record") myflbatchNmelst record, @Param("example") myflbatchNmelstExample example);

    int updateByExample(@Param("record") myflbatchNmelst record, @Param("example") myflbatchNmelstExample example);
}