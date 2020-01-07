package com.virugan.mytoolsbox.mapper;

import com.virugan.mytoolsbox.entry.myAccountDetail;
import com.virugan.mytoolsbox.entry.myAccountDetailExample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface myAccountDetailMapper {
    int countByExample(myAccountDetailExample example);

    int deleteByExample(myAccountDetailExample example);

    int insert(myAccountDetail record);

    int insertSelective(myAccountDetail record);

    List<myAccountDetail> selectByExample(myAccountDetailExample example);

    BigDecimal selectSumAmtsByExample(String sql);

    List<Map<String,Object>> selectSumAmtsByExampleGroup(String sql);

    int updateByExampleSelective(@Param("record") myAccountDetail record, @Param("example") myAccountDetailExample example);

    int updateByExample(@Param("record") myAccountDetail record, @Param("example") myAccountDetailExample example);

    List<myAccountDetail> selectByNameSql(String sql);
}