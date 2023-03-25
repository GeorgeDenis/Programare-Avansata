package org.example.commands;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.example.model.Catalog;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.awt.Desktop;


import freemarker.template.Configuration;
import org.example.exceptions.InvalidCatalogException;


public class ReportCommand implements Command{
    private static final String TEMPLATE_DIR = "templates/";
    private static final String TEMPLATE_NAME = "report.ftl";
    private static final String REPORT_FILE = "report.html";
    private Catalog catalog;
    public ReportCommand(Catalog catalog)
    {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    /**
     * Metoda creează (și deschide) un HTML reprezentând conținutul catalogului, am utilizat FreeMaker
     * @throws IOException
     * @throws TemplateException
     * @throws InvalidCatalogException
     */
    public void execute() throws IOException, TemplateException, InvalidCatalogException {
        if(catalog == null)
        {
            throw new InvalidCatalogException("Catalogul " + catalog.getName() + " nu exista!");
        }
        else {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setClassForTemplateLoading(this.getClass(), "/templates");

            Template template = cfg.getTemplate("catalog.ftl");

            Map<String, Object> data = new HashMap<>();
            data.put("documents", catalog.getDocs());

            StringWriter writer = new StringWriter();
            template.process(data, writer);

            String htmlReport = writer.toString();

            try (FileWriter fileWriter = new FileWriter("catalog.html")) {
                fileWriter.write(htmlReport);
            }

            Desktop.getDesktop().browse(new File("catalog.html").toURI());
        }
    }


}
