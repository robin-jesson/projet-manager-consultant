package com.alten.hercules.consultant;

import java.util.Calendar;

import com.alten.hercules.consultant.entity.Consultant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CreateJsonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GsonBuilder buidler = new GsonBuilder();
		Gson gson = buidler.create();
		
		Calendar date = Calendar.getInstance();
		Consultant c =new Consultant(1,"a@a.fr","robin","jesson","ingé","utbm","jd",true,1,date.getTime());
		System.out.println(c);
		System.out.println(gson.toJson(c));
	}

}
