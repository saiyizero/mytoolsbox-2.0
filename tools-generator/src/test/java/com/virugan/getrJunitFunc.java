package com.virugan;

import com.virugan.component.myEnumType;
import com.virugan.myUtlis.myBeanUtils;
import org.junit.Test;

public class getrJunitFunc {

    @Test
    public void enumUseTest(){

        myEnumType.E_DATBSTYPE e_datbstype = myBeanUtils.toEnum(myEnumType.E_DATBSTYPE.class, "sqlite");
        System.out.println(e_datbstype);
    }
}
