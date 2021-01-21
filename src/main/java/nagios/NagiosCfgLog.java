package nagios;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NagiosCfgLog extends HttpServlet {
    private Configuration config;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Template tpl= config.getTemplate("logsListe.ftl");
        Map<String, Object> model = new HashMap<>();
        List<Switch> sws = new ArrayList();
        sws.add(new Switch("s1","switch1","1.2.3.4","p1"));
        sws.add(new Switch("s2","switch2","1.2.3.5","p2"));
        sws.add(new Switch("s3","switch2","1.2.3.7","p3"));
        sws.add(new Switch("s4","switch3","1.2.3.9",""));
        model.put("switchs",sws);
        try {
            tpl.process(model, response.getWriter());
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
