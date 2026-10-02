package pe.edu.upeu.sysventas.config;
import java.util.HashMap;
import java.util.Map;
import pe.edu.upeu.sysventas.controller.*;
import pe.edu.upeu.sysventas.repository.*;
import pe.edu.upeu.sysventas.service.*;
import pe.edu.upeu.sysventas.service.impl.*;

public class AppContext {
    private static AppContext instance;
    private final Map<Class<?>, Object> contenedor = new HashMap<>();
    public static synchronized AppContext getInstance() {
        if (instance == null) instance = new AppContext();
        return instance;
    }
    private AppContext() {
        registrar(UnidadMedidaRepository.class, new UnidadMedidaRepository());
        registrar(IUnidadMedidaService.class, new UnidadMedidaServiceImp(getBean(UnidadMedidaRepository.class)));
        registrar(UnidadMedidaController.class, new UnidadMedidaController(getBean(IUnidadMedidaService.class)));
        registrar(MainguiController.class, new MainguiController());
    }
    private void registrar(Class<?> tipo, Object objeto) { contenedor.put(tipo, objeto); }
    public <T> T getBean(Class<T> tipo) {
        Object objeto = contenedor.get(tipo);
        if (objeto == null) throw new IllegalArgumentException("Clase no registrada: " + tipo.getName());
        return tipo.cast(objeto);
    }
}
