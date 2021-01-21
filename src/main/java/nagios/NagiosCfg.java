package nagios;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class NagiosCfg extends HttpServlet {
    Configuration config;
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Template tpl= config.getTemplate("formswitch.ftl");
        Map<String, Object> model = new HashMap<>();
        model.put("titre","tp CDA");
        try {
            tpl.process(model, httpServletResponse.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Switch sw = new Switch();
        sw.setName(httpServletRequest.getParameter("name"));
        sw.setFullName(httpServletRequest.getParameter("fullName"));
        sw.setIp(httpServletRequest.getParameter("ip"));
        sw.setParent(httpServletRequest.getParameter("parent"));

        httpServletResponse.setContentType("application/x-msdownload");
        httpServletResponse.setHeader("Content-disposition", "attachment; filename="+ sw.getName()+".cfg");
        Map<String, Object> model = new HashMap<>();
        model.put("switch", sw);
        Template tpl = config.getTemplate("switches.ftl");
        try {
            tpl.process(model, httpServletResponse.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        config = new Configuration(Configuration.VERSION_2_3_30);
        config.setDefaultEncoding("UTF-8");
        config.setServletContextForTemplateLoading(this.getServletContext(),"/WEB-INF/templates");

    }
}
