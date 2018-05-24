package cn.wizzer.app.web.modules.controllers.platform.bond;

import cn.wizzer.app.bond.modules.models.Bond_product;
import cn.wizzer.app.bond.modules.services.BondProductService;
import cn.wizzer.app.cms.modules.models.Cms_article;
import cn.wizzer.app.cms.modules.models.Cms_channel;
import cn.wizzer.app.cms.modules.services.CmsArticleService;
import cn.wizzer.app.cms.modules.services.CmsChannelService;
import cn.wizzer.app.sys.modules.models.Sys_config;
import cn.wizzer.app.sys.modules.models.Sys_user;
import cn.wizzer.app.web.commons.base.Globals;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.rabbit.RabbitMessage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.adaptor.WhaleAdaptor;
import org.nutz.mvc.annotation.*;

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
    public void add() {
    }

    @At
    @Ok("json")
    //@RequiresPermissions("cms.content.article")
    public Object addDo(@Param("..") Bond_product bond_product) {
        try {
            if (bondProductService.insert(bond_product) != null) {
                return Result.success("system.success");
            }
            return Result.error("system.error");
        } catch (Exception e) {
        }
        return null;
    }


    @At("/edit/?")
    @Ok("beetl:/platform/bond/product/edit.html")
    public Object edit(String id) {
        return bondProductService.fetch(id);
    }

    @At
    @Ok("json")
    //@RequiresPermissions("cms.content.article")
    public Object editDo(@Param("..") Bond_product bond_product) {
        if (bondProductService.updateIgnoreNull(bond_product) > 0) {
            return Result.success("system.success");
        }
        return Result.error("system.error");
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    public Object delete(String id, @Param("ids") String[] ids, HttpServletRequest req) {
        try {
            if (ids != null && ids.length > 0) {
                bondProductService.delete(ids);
                req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
            } else {
                bondProductService.delete(id);
                req.setAttribute("id", id);
            }
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At
    @Ok("json:full")
    public Object data(@Param("unitid") String unitid, @Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        if (!Strings.isBlank(unitid) && !"root".equals(unitid))
            cnd.and("unitid", "=", unitid);
        return bondProductService.data(length, start, draw, order, columns, cnd, null);
    }
}
