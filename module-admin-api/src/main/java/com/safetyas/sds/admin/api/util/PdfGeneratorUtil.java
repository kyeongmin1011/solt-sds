package com.safetyas.sds.admin.api.util;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class PdfGeneratorUtil {

  @Autowired
  private TemplateEngine templateEngine;

  public byte[] createPdf(String templateName, Map map) throws Exception {
    Assert.notNull(templateName, "The templateName can not be null");
    Context ctx = new Context();
    if (map != null) {
      Iterator itMap = map.entrySet().iterator();
      while (itMap.hasNext()) {
        Map.Entry pair = (Map.Entry) itMap.next();
        ctx.setVariable(pair.getKey().toString(), pair.getValue());
      }
    }

    String processedHtml = templateEngine.process(templateName, ctx);

    ByteArrayOutputStream os = new ByteArrayOutputStream();
    PdfRendererBuilder builder = new PdfRendererBuilder();
    builder.withHtmlContent(processedHtml,
        PdfGeneratorUtil.class.getResource("/templates/root.html").toExternalForm());
    builder.useFastMode();
    builder.toStream(os);
    builder.run();
    return os.toByteArray();

  }

}
