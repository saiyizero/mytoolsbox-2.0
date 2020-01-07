package com.virugan.mytoolsbox.mapper;

import com.virugan.mytoolsbox.entry.myTpublicParams;
import com.virugan.mytoolsbox.entry.myTpublicParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface myTpublicParamsMapper {
    int countByExample(myTpublicParamsExample example);

    int deleteByExample(myTpublicParamsExample example);

    int insert(myTpublicParams record);

    int insertSelective(myTpublicParams record);

    List<myTpublicParams> selectByExample(myTpublicParamsExample example);

    int updateByExampleSelective(@Param("record") myTpublicParams record, @Param("example") myTpublicParamsExample example);

    int updateByExample(@Param("record") myTpublicParams record, @Param("example") myTpublicParamsExample example);

    int executeSql(String sql);
}