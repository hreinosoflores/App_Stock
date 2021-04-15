package com.example.app_stock.beans;

public class Usuario {
    private Long CODUSUARIO;
    private String NOMBRES;
    private String APELLIDOS;
    private String DNI;
    private String IDLOGIN;
    private String PASSWORD;
    private Boolean ESTADO;

    public Usuario() {
    }

    public Usuario(String NOMBRES, String APELLIDOS, String DNI, String IDLOGIN, String PASSWORD, Boolean ESTADO) {
        this.NOMBRES = NOMBRES;
        this.APELLIDOS = APELLIDOS;
        this.DNI = DNI;
        this.IDLOGIN = IDLOGIN;
        this.PASSWORD = PASSWORD;
        this.ESTADO = ESTADO;
    }

    public Long getCODUSUARIO() {
        return CODUSUARIO;
    }

    public void setCODUSUARIO(Long CODUSUARIO) {
        this.CODUSUARIO = CODUSUARIO;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getIDLOGIN() {
        return IDLOGIN;
    }

    public void setIDLOGIN(String IDLOGIN) {
        this.IDLOGIN = IDLOGIN;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Boolean getESTADO() {
        return ESTADO;
    }

    public void setESTADO(Boolean ESTADO) {
        this.ESTADO = ESTADO;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "CODUSUARIO=" + CODUSUARIO +
                ", NOMBRES='" + NOMBRES + '\'' +
                ", APELLIDOS='" + APELLIDOS + '\'' +
                ", DNI='" + DNI + '\'' +
                ", IDLOGIN='" + IDLOGIN + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", ESTADO=" + ESTADO +
                '}';
    }
}
