package com.reConnect.model;

import java.util.ArrayList;

public class testConnection {
	public static void main(String[] args) {
		UserDAO daoProva = new UserDAO();
		ArrayList<UserVO> arraylist = daoProva.obtainAllUsers();
		UserVO empVOAux;
		System.out.println(arraylist.size());
		for(int i =0 ; i<arraylist.size(); i++) {
			 empVOAux = arraylist.get(i);
			 System.out.print(empVOAux.getName());
			 System.out.println();	
		}
	}
}
