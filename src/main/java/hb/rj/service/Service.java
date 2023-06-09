package hb.rj.service;



import hb.rj.dao.UserDao;
import hb.rj.dbutils.Page;
import hb.rj.pojo.Condition;
import hb.rj.pojo.User;
import org.hibernate.Session;

import java.util.List;

public class Service {
    public List<User> listPage(Session session, UserDao userDao, Page page, Condition condition){
        List<User> list=userDao.getPage(session,page,condition);
        if (list!=null){
            return list;
        }else {
            return null;
        }
    }
    //添加用户
    public boolean UserAdd(Session session,UserDao userDao,User user){
        //先检测当前用户是不是已经被使用
        if (userDao.searchUser(session,user.getUserName())){
            return false;
        }else {
            if (userDao.addUser(session, user) > 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
