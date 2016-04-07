package br.com.cinema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cinema.model.Inscricao;
import br.com.cinema.repository.InscricaoRepository;
import br.com.cinema.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Inscricao.class)
public class InscricaoConverter implements Converter {

	// @Inject
	private InscricaoRepository inscricoes;

	public InscricaoConverter() {
		this.inscricoes = CDIServiceLocator.getBean(InscricaoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Inscricao retorno = null;

		if (value != null) {
			Integer id = new Integer(value);
			retorno = inscricoes.porId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Inscricao inscricao = (Inscricao) value;
			return inscricao.getInscricao_id() == null ? null : inscricao
					.getInscricao_id().toString();
		}

		return "";
	}

}
