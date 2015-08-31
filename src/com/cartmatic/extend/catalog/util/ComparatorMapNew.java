package com.cartmatic.extend.catalog.util;

import java.util.Comparator;

import com.cartmatic.estore.common.model.catalog.Product;

public class ComparatorMapNew implements Comparator
{

	public int compare(Object arg0, Object arg1) {
		Product parg0 = (Product) arg0;
		Product parg1 = (Product) arg1;
		return parg0.getCreateTime().compareTo(parg1.getCreateTime());
	}
}