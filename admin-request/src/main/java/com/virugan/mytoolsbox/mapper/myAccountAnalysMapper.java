package com.virugan.mytoolsbox.mapper;

import com.virugan.mytoolsbox.entry.myAccountAnalys;
import com.virugan.mytoolsbox.entry.myAccountAnalysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface myAccountAnalysMapper {
    int countByExample(myAccountAnalysExample example);

    int deleteByExample(myAccountAnalysExample example);

    int insert(myAccountAnalys record);

    int insertSelective(myAccountAnalys record);

    List<myAccountAnalys> selectByExample(myAccountAnalysExample example);

    int updateByExampleSelective(@Param("record") myAccountAnalys record, @Param("example") myAccountAnalysExample example);

    int updateByExample(@Param("record") myAccountAnalys record, @Param("example") myAccountAnalysExample example);
}