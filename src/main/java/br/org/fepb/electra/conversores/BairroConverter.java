package br.org.fepb.electra.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.stereotype.Component;

import br.org.fepb.electra.modelo.Bairro;

//@FacesConverter("bairroConverter")
@Component
@FacesConverter(forClass=Bairro.class)
public class BairroConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Bairro) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Bairro) {
	            Bairro entity= (Bairro) value;
	            if (entity != null && entity instanceof Bairro && entity.getId() != null) {
	                uiComponent.getAttributes().put( entity.getId().toString(), entity);
	                return entity.getId().toString();
	            }
	        }
	        return "";
	    }

}