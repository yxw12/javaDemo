package com.yxw.ssm.service;


import com.yxw.ssm.entity.Items;
import com.yxw.ssm.entity.QueryVo;

import java.util.List;

public interface ItemService {
	
	//商品查询列表
	public List<Items> findItemsList(QueryVo queryVo)throws Exception;
	
	//根据id查询商品信息
	public Items findItemById(int id) throws Exception;
	
	//修改商品信息
	public void saveItem(Items items)throws Exception;
}
