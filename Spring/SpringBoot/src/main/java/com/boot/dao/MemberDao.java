package com.boot.dao;

import java.io.Serializable;
import java.util.List;

public interface MemberDao<T> extends Serializable{
	
	public List<T> getAll();
	
}
