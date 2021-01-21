package fr.laerce.todo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoFT extends HttpServlet {
    Configuration ftCfg;
    List<String>todos=new ArrayList<>();



    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Template tpl = ftCfg.getTemplate("todo.ftl");
        Map<String, Object> model = new HashMap<>();
        HttpSession session= httpServletRequest.getSession();
        List<String>todoSession=(List<String>) session.getAttribute("todos");
        if (todoSession==null){
            todoSession=new ArrayList<String>();
            session.setAttribute("todos",todoSession);
        }
        // Modele pour FreeMarker
        model.put("todoSession",todoSession);
        model.put("todos",todos);
        try {
            tpl.process(model, httpServletResponse.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        List<String> todoSession = (List<String>) session.getAttribute("todos");
        if(todoSession == null){
            todoSession = new ArrayList<String>();
            session.setAttribute("todos", todoSession);
        }

        String item = httpServletRequest.getParameter("afaire");
        String global = httpServletRequest.getParameter("global");
        if (!item.equals(" ")) { // Juste pour ne pas autoriser d'ajouter des éléments vides
            if (global != null) { // EX2 SI ON DEMANDE DE STOCKER EN GLOBAL

                } else {
                    // EX1 SI ON NE CONTIENT PAS DE DOUBLON

                todoSession.add(item);

                }

            todos.add(item);


        }

        httpServletResponse.sendRedirect("/todoft/ajouter");
    }


    @Override
    public void init() throws ServletException {
        //super.init(servletConfig);
        ftCfg = new Configuration(Configuration.VERSION_2_3_30);
        ftCfg.setDefaultEncoding("UTF-8");
        ftCfg.setServletContextForTemplateLoading(this.getServletContext(),"/WEB-INF/templates");

    }
}
