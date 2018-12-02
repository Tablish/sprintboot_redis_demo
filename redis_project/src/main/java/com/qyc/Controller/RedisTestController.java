package com.qyc.Controller;

import com.qyc.Bean.User;
import com.qyc.Utils.PrimaryKeyUtil;
import com.qyc.Utils.RedisConstants;
import com.qyc.Utils.RedisUtil;
import com.qyc.Utils.StateParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("/redis")
public class RedisTestController extends BaseController{
    @Autowired
    RedisUtil redisUtil;

    /*Logger logger = LoggerFactory.getLogger(RedisTestController.class);
        logger.info("lalala");*/
    /**
     * @auther: zhangyingqi
     * @date: 17:26 2018/8/28
     * @param: []
     * @return: org.springframework.ui.ModelMap
     * @Description: 测试redis存储&读取
     */
    @RequestMapping(value="/test")
    @ResponseBody
    public ModelMap test(){
        try {
            redisUtil.set("redisTemplate","这是一条测试数据", RedisConstants.datebase2);
            String value = redisUtil.get("redisTemplate").toString();
            log.info("redisValue="+value);
            log.info("读取redis成功");
            return getModelMap(StateParameter.SUCCESS, value, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }

    @RequestMapping("/getString")
    @ResponseBody
    public ModelMap getString() {
        String age = redisUtil.get("age").toString();
        System.out.println("[return] "+age);
        return getModelMap(StateParameter.SUCCESS, age, "操作成功");
    }

    @RequestMapping("/setString")
    @ResponseBody
    public ModelMap setString() {
        //String age = redisUtil.get("age").toString();
        boolean set = redisUtil.set("userName", "qianyongchao");
        System.out.println("[return] "+ set);
        return getModelMap(StateParameter.SUCCESS, set, "操作成功");
    }


    @RequestMapping("/hset")
    @ResponseBody
    public ModelMap hashSet() {
        //User user = new User("1", "qianyongchao", "132");
        String oldValue = redisUtil.hget("info11", "userName").toString();

        boolean hset = redisUtil.hset("info11", "userName", oldValue+"_new");
        System.out.println("hset: "+hset);
        return getModelMap(StateParameter.SUCCESS, hset, "操作成功");
    }



    @RequestMapping(value="/setUser")
    @ResponseBody
    public ModelMap setUser(){
        try {
            User user = new User();
            user.setUsername("隔壁老王");
            user.setPassword("28");
            user.setId(PrimaryKeyUtil.get().toString());
            boolean user1 = redisUtil.set("user", user, 2);
            System.out.println("是否设置成功： "+user1);
            User res = (User)redisUtil.get("user");
            log.info("res="+res.toString());
            log.info("读取redis成功");
            return getModelMap(StateParameter.SUCCESS, res, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }
}
