package com.virugan.mytoolsbox.mapper;

import com.virugan.mytoolsbox.entry.myaccountAuodil;
import com.virugan.mytoolsbox.entry.myaccountAuodilExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface myaccountAuodilMapper {
    int countByExample(myaccountAuodilExample example);

    int deleteByExample(myaccountAuodilExample example);

    int insert(myaccountAuodil record);

    int insertSelective(myaccountAuodil record);

    List<myaccountAuodil> selectByExample(myaccountAuodilExample example);

    int updateByExampleSelective(@Param("record") myaccountAuodil record, @Param("example") myaccountAuodilExample example);

    int updateByExample(@Param("record") myaccountAuodil record, @Param("example") myaccountAuodilExample example);
}