package pe.edu.upeu.sysventas.service.impl;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.sysventas.dto.ComboBoxOption;
import pe.edu.upeu.sysventas.model.UnidMedida;
import pe.edu.upeu.sysventas.repository.*;
import pe.edu.upeu.sysventas.service.IUnidadMedidaService;

public class UnidadMedidaServiceImp extends CrudGenericoServiceImp<UnidMedida, Long> implements IUnidadMedidaService {
    private final UnidadMedidaRepository repositorio;
    public UnidadMedidaServiceImp(UnidadMedidaRepository repositorio) {
        this.repositorio = repositorio;
        repositorio.seedData();
    }
    @Override protected ICrudGenericoRepository<UnidMedida, Long> getRepo() { return repositorio; }
    private void validar(UnidMedida entidad, Long idActual) {
        if (entidad == null || entidad.getNombreMedida() == null || entidad.getNombreMedida().trim().isEmpty())
            throw new IllegalArgumentException("Escribe un nombre.");
        String nombre = entidad.getNombreMedida().trim();
        for (UnidMedida existente : findAll()) {
            if (!existente.getIdUnidad().equals(idActual) && existente.getNombreMedida().equalsIgnoreCase(nombre))
                throw new IllegalArgumentException("Ya existe un registro con ese nombre.");
        }
        entidad.setNombreMedida(nombre);
    }
    @Override public UnidMedida save(UnidMedida entidad) {
        validar(entidad, null);
        entidad.setIdUnidad(null);
        return super.save(entidad);
    }
    @Override public UnidMedida update(Long id, UnidMedida entidad) {
        findById(id);
        validar(entidad, id);
        entidad.setIdUnidad(id);
        return super.update(id, entidad);
    }
    @Override public List<ComboBoxOption> listarCombobox() {
        List<ComboBoxOption> lista = new ArrayList<>();
        for (UnidMedida entidad : findAll())
            lista.add(new ComboBoxOption(String.valueOf(entidad.getIdUnidad()), entidad.getNombreMedida()));
        return lista;
    }
}
