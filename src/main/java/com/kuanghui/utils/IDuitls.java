package com.kuanghui.utils;

import java.util.UUID;

public class IDuitls {


        public static String getUUId(){
            return UUID.randomUUID().toString().replace(",","-");
        }
}
