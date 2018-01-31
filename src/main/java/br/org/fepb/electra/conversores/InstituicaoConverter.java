package br.org.fepb.electra.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.stereotype.Component;

import br.org.fepb.electra.modelo.InstituicaoEspirita;

@Component
@FacesConverter(forClass=InstituicaoEspirita.class)
public class InstituicaoConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (InstituicaoEspirita) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof InstituicaoEspirita) {
	            InstituicaoEspirita entity= (InstituicaoEspirita) value;
	            if (entity != null && entity instanceof InstituicaoEspirita && entity.getId() != null) {
	                uiComponent.getAttributes().put( entity.getId().toString(), entity);
	                return entity.getId().toString();
	            }
	        }
	        return "";
	    }

}