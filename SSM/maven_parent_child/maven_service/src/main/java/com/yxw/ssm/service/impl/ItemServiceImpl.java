package com.yxw.ssm.service.impl;


import com.yxw.ssm.mapper.ItemsMapper;
import com.yxw.ssm.mapper.ItemsMapperCustom;
import com.yxw.ssm.entity.Items;
import com.yxw.ssm.entity.QueryVo;
import com.yxw.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> findItemsList(QueryVo queryVo) throws Exception {
		//查询商品信息
		return itemsMapperCustom.findItemsList(queryVo);
	}

	@Override
	public Items findItemById(int id) throws Exception {
		
		
		return itemsMapperCustom.findItemById(id);
	}

	@Override
	public void saveItem(Items items) throws Exception {
		int i=1/0;
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
		
	}

}
