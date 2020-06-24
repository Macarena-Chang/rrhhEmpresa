package ar.com.ada.api.rrhh.models.requests;

import java.math.BigDecimal;

public class InfoBasicaEmpleadoRequest {
    //obj que se utilizara en capa controller. 
    //un obj mas "chico"
    //no hacemos ni getters ni setters xq no tendra funcionalidad, solo sirve para transporte

    public String nombre;
    public int edad;
    public BigDecimal sueldo;
    public int categoriaId;


}