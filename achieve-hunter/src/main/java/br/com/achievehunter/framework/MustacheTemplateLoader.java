package br.com.achievehunter.framework;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.view.mustache.jmustache.JMustacheTemplateLoader;

public class MustacheTemplateLoader extends JMustacheTemplateLoader {

	private ResourceLoader resourceLoader;
	
	private String prefix = "";

    private String suffix = "";
    
    private String encoding = null;
	    
	@Override
	public Reader getTemplate(String filename) throws Exception {
		 if (!filename.startsWith(prefix)) {
	            filename = prefix + filename;
	        }
	        if (!filename.endsWith(suffix)) {
	            filename = filename + suffix;
	        }
	        Resource resource = resourceLoader.getResource(filename);
	        if (resource.exists()) {
	            return new InputStreamReader(resource.getInputStream(), getCharset());
	        }
	        throw new FileNotFoundException(filename);
	}
	
	@Override
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	@Override
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public Charset getCharset(){
		if(encoding == null){
			return Charset.forName("UTF-8");
		}
		return Charset.forName(encoding);
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader  = resourceLoader;
	}
}
