
package com.gl.club.common.securitymanage.bridge.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.club.common.base.entity.IdEntity;
import com.gl.club.common.securitymanage.bridge.BridgeService;
import com.gl.club.common.tools.Constants;
import com.gl.club.dao.SysOperatorDao;
import com.gl.club.dao.SysUserDao;
import com.gl.club.entity.SysOperator;
import com.gl.club.entity.SysResource;
import com.gl.club.entity.SysRole;
import com.gl.club.entity.SysUser;


@Service("bridgeService")
public class BridgServiceImpl implements BridgeService {

	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysOperatorDao sysOperatorDao;
	
	/**
	 * 随机数字字母
	 */
	private char mapTable[]={   
            'a','b','c','d','e','h',   
            'j','k','m','n','p','q',   
            'r','s','t','u','v','w',   
            'x','y','z','0','2','3',   
            '4','5','6','7','8','9'  
    };
	
	@Override
	public String getCertPic(int width, int height, OutputStream outputStream) {
		if(width<=0) {   
            width=60;   
        }   
        if(height<=0) {   
            height=22;
        }   
           
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);   
        //获取图形上下文   
        Graphics g = image.getGraphics();   
        //设定背景颜色   
        g.setColor(new Color(0xDCDCDC));   
        g.fillRect(0, 0, width, height);   
        //画边框   
       // g.setColor(Color.black);
        g.setColor(new Color(2, 67, 121));
        g.drawRect(0, 0, width-1, height-1);   
        //随机产生的验证码   
        String strEnsure="";   
        //4代表4位验证码，如果要生成等多位的验证码 ，则加大数值   
           
        for(int i=0; i<4; i++) {   
            strEnsure += mapTable[(int)(mapTable.length*Math.random())];   
        }   
        //将验证码显示在图像中，如果要生成更多位的验证码，增加drawString语句   
        g.setColor(new Color(0x003399));   
        g.setFont(new Font("Atlantic Inline", Font.PLAIN,18));   
        String str = strEnsure.substring(0, 1);   
        g.drawString(str, 8, 17);   
         str = strEnsure.substring(1, 2);   
         g.drawString(str, 20, 15);   
         str = strEnsure.substring(2, 3);   
         g.drawString(str, 35, 18);   
         str = strEnsure.substring(3, 4);   
         g.drawString(str, 45, 15);   
         //随机产生10个干扰点   
            
         Random random = new Random();   
         for(int i=0; i<10; i++ ) {   
             int x = random.nextInt(width);   
             int y = random.nextInt(height);   
             g.drawOval(x, y, 1, 1);   
         }   
        //释放图形上下文   
         g.dispose();   
         try{   
             //输出图像到页面   
             ImageIO.write(image, "JPEG", outputStream);  
             outputStream.flush();
         }catch(IOException e) {   
        	 e.printStackTrace();
         }finally{
        	 try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
         }
        return strEnsure; 
	}

	@Override
	public SysUser getSysUserByLoginName(String loginName) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer jpql = new StringBuffer();
		jpql.append("From SysUser where (loginName = :loginName or mobile = :loginName or email=:loginName) and enableFlag=:enableFlag ");
		map.put("loginName", loginName);
		map.put("enableFlag", IdEntity.EnableFlag.YES);
		return sysUserDao.findUnique(jpql.toString(),map) ;
	}

	@Override
	public List<SysRole> findRoleByUserId(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select role.label as lable from tbl_user_role ur ");
		sql.append("left join  tbl_sys_role role on ur.roleId = role.id ");
		sql.append("where ur.id = :userId and role.enable_flag = :enableFlag ");
		map.put("userId", id);
		map.put("enableFlag", Constants.YES);
		return sysOperatorDao.findListResultSql(sql.toString(), map, SysRole.class);
	}

	@Override
	public List<SysResource> findByUserId(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select re.label as lable from tbl_user_resource ur ");
		sql.append("left join  tbl_sys_resource re on ur.resource_id = re.id ");
		sql.append("where ur.owner_id = :userId and re.enable_flag = :enableFlag  ");
		map.put("userId", id);
		map.put("enableFlag", Constants.YES);
		return sysOperatorDao.findListResultSql(sql.toString(), map, SysResource.class);
	}

	@Override
	public SysOperator getOperatorById(String id) {
		
		return sysOperatorDao.findOne(id);
	}

}
