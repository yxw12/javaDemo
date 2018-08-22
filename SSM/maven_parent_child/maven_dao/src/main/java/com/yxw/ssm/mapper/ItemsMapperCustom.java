package com.yxw.ssm.mapper;


import com.yxw.ssm.entity.Items;
import com.yxw.ssm.entity.QueryVo;

import java.util.List;

public interface ItemsMapperCustom {
	
	//商品列表
	public List<Items> findItemsList(QueryVo queryVo) throws Exception;
	
	//根据id查询商品信息
	public Items findItemById(int id) throws Exception;
}
