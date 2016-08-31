package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.ByAdvertise;

/***
 * 
 * <b>类名：</b>ByAdvertiseDao.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>轮播广告位Dao</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-15 上午11:16:27
 */
public interface ByAdvertiseDao extends BaseRepository<ByAdvertise, String>,BaseSqlRepository<ByAdvertise, String>,BaseHqlRepository<ByAdvertise, String>{

}
