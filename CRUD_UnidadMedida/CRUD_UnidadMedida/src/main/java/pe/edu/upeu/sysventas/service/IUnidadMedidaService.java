package pe.edu.upeu.sysventas.service;

import pe.edu.upeu.sysventas.dto.ComboBoxOption;
import pe.edu.upeu.sysventas.model.UnidMedida;

import java.util.List;
// se herreda de iCrudgenericoservice
public interface IUnidadMedidaService extends ICrudGenericoService<UnidMedida, Long> {
    List<ComboBoxOption> listarCombobox();
}
