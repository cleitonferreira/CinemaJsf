package br.com.cinema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cinema.model.Cidade;
import br.com.cinema.repository.CidadeRepository;
import br.com.cinema.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Cidade.class)
public class CidadeConverter implements Converter {

	// @Inject
	private CidadeRepository cidades;

	public CidadeConverter() {
		this.cidades = CDIServiceLocator.getBean(CidadeRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Cidade retorno = null;

		if (value != null) {
			Integer id = new Integer(value);
			retorno = cidades.porId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Cidade cidade = (Cidade) value;
			return cidade.getCid_id() == null ? null : cidade.getCid_id()
					.toString();
		}

		return "";
	}

}
