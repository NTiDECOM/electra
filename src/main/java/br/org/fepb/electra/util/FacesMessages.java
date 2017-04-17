package br.org.fepb.electra.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class FacesMessages implements Serializable {

	private static final long serialVersionUID = 1L;

	private void add(String message, Severity severity) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(message);
		msg.setSeverity(severity);
		
		context.addMessage(null, msg);
	}
	
	public void info(String message) {
		add(message, FacesMessage.SEVERITY_INFO);
	}
	
	public void error(String message) {
		add(message, FacesMessage.SEVERITY_ERROR);
	}
	
	/**
	 * Limpa os dados dos componentes de edição e de seus filhos,
	 * recursivamente. Checa se o componente é instância de EditableValueHolder
	 * e 'reseta' suas propriedades.
	 * <p>
	 * Quando este método, por algum motivo, não funcionar, parta para ignorância
	 * e limpe o componente assim:
	 * <p><blockquote><pre>
	 * 	component.getChildren().clear()
	 * </pre></blockquote>
	 * :-)
	 */
	public static void cleanSubmittedValues(UIComponent component) {
		if (component instanceof EditableValueHolder) {
			EditableValueHolder evh = (EditableValueHolder) component;
			evh.setSubmittedValue(null);
			evh.setValue(null);
			evh.setLocalValueSet(false);
			evh.setValid(true);
		}
		if(component.getChildCount()>0){
			for (UIComponent child : component.getChildren()) {
				cleanSubmittedValues(child);
			}
		}
	}
	
	public static void cleanSubmittedValues(String componentName) {
		UIComponent component = getContext().getViewRoot().findComponent(componentName);
		if (component != null)
			cleanSubmittedValues(component);
	}
	
	/**
     * Recupera o contexto.
     * 
     * @return
     */
    public static FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }
	
}