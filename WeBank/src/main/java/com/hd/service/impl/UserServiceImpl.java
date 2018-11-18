package com.hd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hd.common.BaseConditionVO;
import com.hd.dao.UserbeanMapper;
import com.hd.model.Userbean;
import com.hd.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private UserbeanMapper dao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Userbean record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(Userbean record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public Userbean selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Userbean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Userbean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public List<Userbean> queryAll() {
		return dao.queryAll();
		
	}

	@Override
	public PageInfo<Userbean> query(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<Userbean> list=dao.query(vo);
		PageInfo<Userbean> pageInfo=new PageInfo<Userbean>(list);
		return pageInfo;
	}

}
