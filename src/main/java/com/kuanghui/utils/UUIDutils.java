package com.kuanghui.utils;

import java.util.UUID;

public class UUIDutils {
        public static String getUUId(){
            return UUID.randomUUID().toString().replace(",","-");
        }

}
