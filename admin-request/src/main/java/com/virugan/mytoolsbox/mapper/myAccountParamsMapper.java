package com.virugan.mytoolsbox.mapper;

import com.virugan.mytoolsbox.entry.myAccountParams;
import com.virugan.mytoolsbox.entry.myAccountParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface myAccountParamsMapper {
    int countByExample(myAccountParamsExample example);

    int deleteByExample(myAccountParamsExample example);

    int insert(myAccountParams record);

    int insertSelective(myAccountParams record);

    List<myAccountParams> selectByExample(myAccountParamsExample example);

    int updateByExampleSelective(@Param("record") myAccountParams record, @Param("example") myAccountParamsExample example);

    int updateByExample(@Param("record") myAccountParams record, @Param("example") myAccountParamsExample example);

    int executeSql(String sql);
}