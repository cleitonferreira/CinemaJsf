package br.com.cinema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cinema.model.Estado;
import br.com.cinema.repository.EstadoRepository;
import br.com.cinema.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter {

	// @Inject
	private EstadoRepository estados;

	public EstadoConverter() {
		this.estados = CDIServiceLocator.getBean(EstadoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Estado retorno = null;

		if (value != null) {
			Integer id = new Integer(value);
			retorno = estados.porId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Estado estado = (Estado) value;
			return estado.getEst_id() == null ? null : estado.getEst_id()
					.toString();
		}

		return "";
	}

}
