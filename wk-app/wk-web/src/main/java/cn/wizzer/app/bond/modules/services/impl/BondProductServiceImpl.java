package cn.wizzer.app.bond.modules.services.impl;

import cn.wizzer.app.bond.modules.models.Bond_product;
import cn.wizzer.app.bond.modules.services.BondProductService;
import cn.wizzer.app.cms.modules.models.Cms_article;
import cn.wizzer.app.cms.modules.services.CmsArticleService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class BondProductServiceImpl extends BaseServiceImpl<Bond_product> implements BondProductService {
    public BondProductServiceImpl(Dao dao) {
        super(dao);
    }
}
