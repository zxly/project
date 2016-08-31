package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.GameScore;

public interface GameScoreDao extends BaseRepository<GameScore, String>,BaseSqlRepository<GameScore, String>,BaseHqlRepository<GameScore, String>{

}
