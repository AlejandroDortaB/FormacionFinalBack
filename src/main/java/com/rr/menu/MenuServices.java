package com.rr.menu;


import org.springframework.stereotype.Service;

import com.rr.base.BaseService;


@Service
public class MenuServices extends BaseService<Menu, MenuRepository>{

	public MenuServices(MenuRepository repository) {
		super(repository);
	}

	

}
