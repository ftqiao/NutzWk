package cn.wizzer.app.web.modules.controllers.platform.bond;

import cn.wizzer.app.bond.modules.models.Bond_product;
import cn.wizzer.app.bond.modules.services.BondProductService;
import cn.wizzer.app.cms.modules.models.Cms_article;
import cn.wizzer.app.cms.modules.models.Cms_channel;
import cn.wizzer.app.cms.modules.services.CmsArticleService;
import cn.wizzer.app.cms.modules.services.CmsChannelService;
import cn.wizzer.app.sys.modules.models.Sys_user;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.adaptor.WhaleAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wizzer on 2016/6/28.
 */
@IocBean
@At("/platform/bond/product")
public class BondProductController {
    private static final Log log = Logs.get();
    @Inject
    private BondProductService bondProductService;

    @At("")
    @Ok("beetl:/platform/bond/product/index.html")
    //@RequiresPermissions("cms.content.article")
    public void index() {
    }

    @At
    @Ok("beetl:/platform/bond/product/add.html")
    //@RequiresPermissions("cms.content.article")
    public void add(@Param("channelId") String channelId, HttpServletRequest req) {
//        Subject subject = SecurityUtils.getSubject();
//        Sys_user user = (Sys_user) subject.getPrincipal();
//        req.setAttribute("username", user == null ? "" : user.getUsername());
        log.info("增加一个产品成功");
    }

    @At("/edit/?")
    @Ok("beetl:/platform/bond/product/edit.html")
    //@RequiresPermissions("cms.content.article")
    public Object edit(String id, HttpServletRequest req) {
        Bond_product product = bondProductService.fetch(id);
        req.setAttribute("product", product);
        return product;
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("cms.content.article.delete")
    @SLog(tag = "删除文章", msg = "ID:${args[2].getAttribute('id')}")
    public Object delete(String oneId, @Param("ids") String[] ids, HttpServletRequest req) {
        try {
            if (ids != null && ids.length > 0) {
                bondProductService.delete(ids);
                req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
            } else {
                bondProductService.delete(oneId);
                req.setAttribute("id", oneId);
            }
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }
}
