/*
 * @author hoangnguyen
 * @date Apr 28, 2020
 * @version 1.0
 */

package catStore.util;

import javax.servlet.http.HttpServletRequest;

import admin.model.bean.Role;
import admin.model.bean.User;

public class Authentication {
    public static boolean isLogin(HttpServletRequest request) {
        if(request.getSession().getAttribute("user") != null) {
            return true;
        }
        return false;
    }
    
    public static boolean canCreateNewOrder(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        
        for(Role role : user.getRoles()) {
            if(role.getId().compareTo("R0006") == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean canViewOrderDetails(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        
        for(Role role : user.getRoles()) {
            if(role.getId().compareTo("R0007") == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean canViewOrderList(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        
        for(Role role : user.getRoles()) {
            if(role.getId().compareTo("R0008") == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean canViewCustomerDetails(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        
        for(Role role : user.getRoles()) {
            if(role.getId().compareTo("R0009") == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean canViewCustomerList(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        
        for(Role role : user.getRoles()) {
            if(role.getId().compareTo("R0010") == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean canCreateNewProduct(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        
        for(Role role : user.getRoles()) {
            if(role.getId().compareTo("R0011") == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean canUpdateProduct(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        
        for(Role role : user.getRoles()) {
            if(role.getId().compareTo("R0012") == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean canViewProductList(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        
        for(Role role : user.getRoles()) {
            if(role.getId().compareTo("R0013") == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean canDeleteProduct(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        
        for(Role role : user.getRoles()) {
            if(role.getId().compareTo("R0017") == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean canDeleteAnOrder(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        
        for(Role role : user.getRoles()) {
            if(role.getId().compareTo("R0018") == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean canViewDashboard(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        
        for(Role role : user.getRoles()) {
            if(role.getId().compareTo("R0024") == 0) {
                return true;
            }
        }
        
        return false;
    }
}
