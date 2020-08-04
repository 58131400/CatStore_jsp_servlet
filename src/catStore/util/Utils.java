/*
 * @author hoangnguyen
 * @date Apr 28, 2020
 * @version 1.0
 */

package catStore.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import admin.model.bean.Orders;

import admin.model.bean.Product;
import admin.model.bean.Role;

public class Utils {
    private static int maxOfProductId(ArrayList<Product> products) {
        List<Integer> id = products.stream()
                .map(item -> Integer.valueOf(item.getId().substring(2)))
                .collect(Collectors.toList());
        int max = 0;
        for(int i : id) {
            if(max < i) max = i;
        }
        return max + 1;
    }
    
    private static int maxOfOrdersId(ArrayList<Orders> orders) {
        List<Integer> id = orders.stream()
                .map(item -> Integer.valueOf(item.getId().substring(2)))
                .collect(Collectors.toList());
        int max = 0;
        for(int i : id) {
            if(max < i) max = i;
        }
        return max + 1;
    }
    
    private static String to3Number(int num) {
        if(num < 10) return "00" + num;
        if(num < 100) return "0" + num;
        return String.valueOf(num);
    }
    
    public static String productCatId(ArrayList<Product> cats) {
        return "CA" + to3Number(maxOfProductId(cats));
    }
    
    public static String productClothesId(ArrayList<Product> clothes) {
        return "CL" + to3Number(maxOfProductId(clothes));
    }
    
    public static String productFoodId(ArrayList<Product> foods) {
        return "FD" + to3Number(maxOfProductId(foods));
    }
    
    public static String ordersId(ArrayList<Orders> orders) {
        return "OD" + to3Number(maxOfOrdersId(orders));
    }
    
    public static boolean isInList(ArrayList<Role> roles, Role role) {
        List<String> idList = roles.stream()
            .map(item -> item.getId())
            .collect(Collectors.toList());
        
        for(String id : idList) {
            if(role.getId().equals(id)) return true;
        }
        
        return false;
    }
}
